package com.example.core.domain.gift;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gift extends BaseTimeEntity {

    @Id
    @Column(name = "gift_id")
    @GeneratedValue
    private Long id;

    private Long userId;

    @Builder
    public Gift(Long userId) {
        this.userId = userId;
    }
}
