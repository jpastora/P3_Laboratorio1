package com.pastora.laboratorio1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponseDto(
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("refresh_token") String refreshToken,
        @JsonProperty("token_type") String tokenType,
        @JsonProperty("expires_in") Integer expiresIn
) {
}