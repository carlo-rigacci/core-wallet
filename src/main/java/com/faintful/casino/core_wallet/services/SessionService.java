package com.faintful.casino.core_wallet.services;

import com.faintful.casino.core_wallet.model.OpenSessionRequestDTO;
import com.faintful.casino.core_wallet.model.OpenSessionResponseDTO;

public interface SessionService {
    OpenSessionResponseDTO open(OpenSessionRequestDTO openSessionRequestDTO);
}
