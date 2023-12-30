package com.example.core.domain.gift;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaAuditing
@DataJpaTest
class GiftRepositoryTest {

    @Autowired
    GiftRepository giftRepository;

    @Test
    void BaseTimeEntity_테스트() {
        // given
        Gift gift = giftRepository.save(Gift.builder()
                .userId(1L)
                .build());

        // when
        LocalDateTime applyTime = gift.getCreatedDate();

        // then
        assertThat(applyTime).isBefore(LocalDateTime.now());
    }

    @Test
    void 선물_요청_등록() {
        // given
        Gift gift = Gift.builder()
                .userId(1L)
                .build();
        // when
        Gift result = giftRepository.save(gift);

        // then
        assertThat(result.getId()).isEqualTo(1L);
    }

}