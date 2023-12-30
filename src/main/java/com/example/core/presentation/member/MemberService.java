package com.example.core.presentation.member;

import com.example.core.domain.member.Member;
import com.example.core.domain.member.MemberRepository;
import com.example.core.dto.request.member.MemberRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void registerUser(MemberRegisterDto dto) {
        memberRepository.save(dto.toEntity());
    }
}
