package com.hong.tms.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hong.tms.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {

  @Autowired
  private MemberService memberService;

  @Test
  public void testInsert() {
    MemberDTO dto = MemberDTO.builder()
        .memberId("test")
        .memberPw("1234")
        .memberPhone("010-9072-1234")
        .memberCompany("hongcompany")
        .memberVehicleType("1")
        .memberVehicleNumber("365노1234")
        .memberType(0)
        .build();
    MemberDTO joinedDTO = memberService.join(dto);
    log.info("joinedDTO >>> {} ", joinedDTO);
  }

  @Test
  public void testLogin() {
    MemberDTO dto = MemberDTO.builder()
        .memberId("test")
        .memberPw("1234")
        .memberPhone("010-9072-1234")
        .memberCompany("hongcompany")
        .memberVehicleType("1")
        .memberVehicleNumber("365노1234")
        .memberType(0)
        .build();

    Boolean isLoggedIn = memberService.login(dto);
    log.info("isLoggedIn >>> {} ", isLoggedIn);
  }

}
