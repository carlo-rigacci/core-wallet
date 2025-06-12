package com.faintful.casino.controller;

import com.faintful.casino.model.CloseSessionRequestDto;
import com.faintful.casino.model.CloseSessionResponseDto;
import com.faintful.casino.model.OpenSessionRequestDto;
import com.faintful.casino.model.OpenSessionResponseDto;
import com.faintful.casino.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(SessionController.SESSION_PATH)
public class SessionController {
    public final static String SESSION_PATH = "/core-wallet/session";
    @Autowired
    SessionService sessionService;
    @PostMapping("/open")
    OpenSessionResponseDto openSession(@RequestBody OpenSessionRequestDto openSessionRequestDto) {
        return sessionService.open(openSessionRequestDto);
    }
    @PostMapping("/close")
    CloseSessionResponseDto closeSession(@RequestBody CloseSessionRequestDto closeSessionRequestDto) {
        return sessionService.close(closeSessionRequestDto);
    }
}
