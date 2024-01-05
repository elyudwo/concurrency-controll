package com.example.core.domain.gift;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gift extends BaseTimeEntity {

    @Id
    @Column(name = "gift_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(name = "gift_name")
    private String giftName;

    @Builder
    public Gift(Long userId, String giftName) {
        this.userId = userId;
        this.giftName = giftName;
    }
}
