package com.example.core.dto.response.gift;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GiftResponseDto {

    private Long userId;

    @Builder
    public GiftResponseDto(Long userId) {
        this.userId = userId;
    }

}
