package com.example.core.presentation.gift;


import com.example.core.domain.gift.Gift;
import com.example.core.domain.gift.GiftRepository;
import com.example.core.dto.request.gift.GiftRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GiftServiceTest {

    @InjectMocks
    GiftService giftService;

    @Mock
    GiftRepository giftRepository;

    @Test
    void 선물_등록() {
        // given
        GiftRequestDto gift = GiftRequestDto.builder()
                .userId(1L)
                .build();
        when(giftRepository.save(any())).thenReturn(gift.toGift());

        // when
        Long userId = giftService.requestGift(gift);

        // then
        Assertions.assertThat(userId).isEqualTo(1L);
    }

}