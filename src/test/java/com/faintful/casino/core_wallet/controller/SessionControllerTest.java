package com.faintful.casino.core_wallet.controller;

import com.faintful.casino.core_wallet.model.GameMode;
import com.faintful.casino.core_wallet.model.OpenSessionRequestDTO;
import com.faintful.casino.core_wallet.model.OpenSessionResponseDTO;
import com.faintful.casino.core_wallet.services.SessionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@Slf4j
@WebMvcTest(SessionController.class)
public class SessionControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private SessionService sessionService;
    @TestConfiguration
    static class MockConfig {
        @Bean
        SessionService gameLaunchService() {
            return Mockito.mock(SessionService.class);
        }
    }

    @Test
    void successfullyReturnsOpenSessionResponseFromOpenSessionRequest() throws Exception {
        //Arrange
        OpenSessionRequestDTO openSessionRequestDTO = OpenSessionRequestDTO.builder()
                .playerId(1234567890L)
                .gameId(123)
                .deviceId(1)
                .ip("123.123.123.123")
                .currency("Euro")
                .mode(GameMode.DESKTOP)
                .build();

        MockHttpServletRequestBuilder mockPostRequest = MockMvcRequestBuilders
                .post(SessionController.SESSION_PATH + "/open")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(openSessionRequestDTO));

        OpenSessionResponseDTO openSessionResponseDTO = OpenSessionResponseDTO.builder()
                .sessionId("123")
                .admId("123")
                .balance(BigDecimal.valueOf(1234567890))
                .build();

        BDDMockito.given(sessionService.open(openSessionRequestDTO)).willReturn(openSessionResponseDTO);

        //Act

        ResultActions resultActions = mockMvc.perform(mockPostRequest)
                //Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sessionId").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.admId").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value("1234567890"));
        //Log

        log.info(resultActions.andReturn().getResponse().getContentAsString());
    }
}
