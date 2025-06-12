package com.faintful.casino.client;

import com.faintful.casino.model.CloseSessionRequestDto;
import com.faintful.casino.model.CloseSessionResponseDto;
import com.faintful.casino.model.OpenSessionRequestDto;
import com.faintful.casino.model.OpenSessionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "coreFeignClient", url = "${core.client.url}")
public interface CoreFeignClient {
    @PostMapping("/core-wallet/session/open")
    OpenSessionResponseDto openSession(@RequestBody OpenSessionRequestDto openSessionRequestDto);

    @PostMapping("/core-wallet/session/close")
    CloseSessionResponseDto closeSession(@RequestBody CloseSessionRequestDto closeSessionRequestDto);
}
