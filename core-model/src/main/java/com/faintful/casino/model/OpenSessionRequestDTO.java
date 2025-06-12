package com.faintful.casino.core_wallet.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenSessionRequestDTO {
    Long playerId;
    Integer gameId;
    Integer deviceId;
    String ip;
    String currency;
    GameMode mode;
}
