package com.hong.tms.service;

import org.springframework.stereotype.Service;

import com.hong.tms.dto.MemberDTO;
import com.hong.tms.entity.MemberEntity;
import com.hong.tms.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Boolean login(MemberDTO dto) {
    MemberEntity e = memberRepository.findByMemberId(dto.getMemberId()).orElseThrow();

    if (e.getMemberPw().equals(dto.getMemberPw())) {
      return true;
    } else {
      return false;
    }

  }

  public MemberDTO join(MemberDTO dto) {
    MemberEntity e = dto.toEntity();
    memberRepository.save(e);

    return new MemberDTO(e);
  }
}
