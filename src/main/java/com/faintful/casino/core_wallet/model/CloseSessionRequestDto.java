package com.faintful.casino.core_wallet.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CloseSessionRequestDto {
    String sessionId;
}
