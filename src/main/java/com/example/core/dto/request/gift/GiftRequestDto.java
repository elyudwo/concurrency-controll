package com.example.core.dto.request.gift;

import com.example.core.domain.gift.Gift;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GiftRequestDto {

    private Long userId;

    @Builder
    public GiftRequestDto(Long userId) {
        this.userId = userId;
    }

    public Gift toGift() {
        return Gift.builder()
                .userId(userId)
                .build();
    }
}
