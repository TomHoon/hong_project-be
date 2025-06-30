package com.hong.tms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hong.tms.common.ApiResponse;
import com.hong.tms.dto.MemberDTO;
import com.hong.tms.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/login")
  @Operation(summary = "로그인", description = "로그인 성공여부 리턴")
  public ResponseEntity<ApiResponse<Boolean>> login(@RequestBody MemberDTO dto) {
    Boolean isSuccess = memberService.login(dto);

    return ResponseEntity.ok(ApiResponse.success(isSuccess));
  }

  @PostMapping("/join")
  @Operation(summary = "회원가입", description = "회원가입 성공 후 결과 리턴")
  public ResponseEntity<ApiResponse<MemberDTO>> join(@RequestBody MemberDTO dto) {

    MemberDTO joinedDTO = memberService.join(dto);

    return ResponseEntity.ok(ApiResponse.success(joinedDTO));
  }

}
