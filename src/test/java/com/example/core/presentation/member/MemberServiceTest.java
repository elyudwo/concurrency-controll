package com.example.core.presentation.member;

import com.example.core.domain.member.MemberRepository;
import com.example.core.dto.request.member.MemberRegisterDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Test
    void 선물_등록() {
        // given
        MemberRegisterDto dto = MemberRegisterDto.builder()
                .name("lyj")
                .build();
        when(memberRepository.save(any())).thenReturn(dto.toEntity());

        // when, then
        memberService.registerUser(dto);
    }

}