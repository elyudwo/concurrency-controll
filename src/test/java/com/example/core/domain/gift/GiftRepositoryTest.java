package com.example.core.domain.gift;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@EnableJpaAuditing
@DataJpaTest
class GiftRepositoryTest {

    @Autowired
    GiftRepository giftRepository;

    @Test
    void BaseTimeEntity_테스트() {
        Gift gift = giftRepository.save(Gift.builder()
                .userId(1L)
                .build());

        Assertions.assertThat(gift.getCreatedDate()).isBefore(LocalDateTime.now());
    }

}