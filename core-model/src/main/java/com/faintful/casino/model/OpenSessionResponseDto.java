package com.faintful.casino.model;

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
