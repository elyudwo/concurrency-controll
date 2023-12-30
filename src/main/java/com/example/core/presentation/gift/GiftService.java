package com.example.core.presentation.gift;

import com.example.core.domain.gift.Gift;
import com.example.core.domain.gift.GiftRepository;
import com.example.core.dto.request.gift.GiftRequestDto;
import com.example.core.dto.response.gift.GiftResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;

    public Long requestGift(GiftRequestDto giftRequest) {
        Gift gift = giftRepository.save(giftRequest.toGift());
        return gift.getUserId();
    }
}
