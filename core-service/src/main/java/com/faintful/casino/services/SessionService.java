package com.faintful.casino.services;

import com.faintful.casino.model.CloseSessionRequestDto;
import com.faintful.casino.model.CloseSessionResponseDto;
import com.faintful.casino.model.OpenSessionRequestDto;
import com.faintful.casino.model.OpenSessionResponseDto;

public interface SessionService {
    OpenSessionResponseDto open(OpenSessionRequestDto openSessionRequestDto);
    CloseSessionResponseDto close(CloseSessionRequestDto closeSessionRequestDto);
}
