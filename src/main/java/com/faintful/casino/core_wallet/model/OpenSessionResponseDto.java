package com.faintful.casino.core_wallet.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OpenSessionResponseDto {
    String sessionId;
    String admId;
    BigDecimal balance;
}
