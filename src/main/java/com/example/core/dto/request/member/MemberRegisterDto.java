package com.example.core.dto.request.member;

import com.example.core.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRegisterDto {

    private String name;

    @Builder
    public MemberRegisterDto(String name) {
        this.name = name;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .build();
    }
}
