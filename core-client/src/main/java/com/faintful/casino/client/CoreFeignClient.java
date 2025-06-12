package com.faintful.casino.core_wallet.client;

import com.faintful.casino.core_wallet.controller.SessionController;
import com.faintful.casino.core_wallet.model.CloseSessionRequestDto;
import com.faintful.casino.core_wallet.model.CloseSessionResponseDto;
import com.faintful.casino.core_wallet.model.OpenSessionRequestDTO;
import com.faintful.casino.core_wallet.model.OpenSessionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "coreFeignClient", url = "${core.client.url}")
public interface CoreFeignClient {
    //TODO: remove constants
    @PostMapping(SessionController.SESSION_PATH + "/open")
    OpenSessionResponseDto openSession(@RequestBody OpenSessionRequestDTO openSessionRequestDTO);

    @PostMapping(SessionController.SESSION_PATH + "/close")
    CloseSessionResponseDto closeSession(@RequestBody CloseSessionRequestDto closeSessionRequestDto
}
