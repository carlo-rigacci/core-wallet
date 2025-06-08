package com.faintful.casino.core_wallet.controller;

import com.faintful.casino.core_wallet.model.OpenSessionRequestDTO;
import com.faintful.casino.core_wallet.model.OpenSessionResponseDTO;
import com.faintful.casino.core_wallet.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SessionController.SESSION_PATH)
public class SessionController {
    public final static String SESSION_PATH = "/core-wallet/session";
    @Autowired
    SessionService sessionService;
    @PostMapping("/open")
    OpenSessionResponseDTO openSession(@RequestBody OpenSessionRequestDTO openSessionRequestDTO) {
        return sessionService.open(openSessionRequestDTO);
    }
}
