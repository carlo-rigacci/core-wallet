package com.faintful.casino.model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class OpenSessionRequestDto {
    Long playerId;
    Integer gameId;
    Integer deviceId;
    String ip;
    String currency;
    GameMode mode;
}
