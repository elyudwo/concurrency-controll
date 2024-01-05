package com.example.core.domain.stock;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class GiftStock {

    @Id
    @Column(name = "gift_id")
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    private String giftName;
    private Long stock;

    public void minusStock() {
        stock -= 1;
    }

    @Builder
    public GiftStock(String giftName, Long stock) {
        this.giftName = giftName;
        this.stock = stock;
    }
}
