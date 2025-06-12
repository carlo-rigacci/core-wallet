package com.faintful.casino.core_wallet.services;

import com.faintful.casino.core_wallet.model.CloseSessionRequestDto;
import com.faintful.casino.core_wallet.model.CloseSessionResponseDto;
import com.faintful.casino.core_wallet.model.OpenSessionRequestDTO;
import com.faintful.casino.core_wallet.model.OpenSessionResponseDto;

public interface SessionService {
    OpenSessionResponseDto open(OpenSessionRequestDTO openSessionRequestDto);
    CloseSessionResponseDto close(CloseSessionRequestDto closeSessionRequestDto);
}
