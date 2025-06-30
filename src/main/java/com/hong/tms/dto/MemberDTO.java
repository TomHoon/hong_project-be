package com.hong.tms.dto;

import java.time.LocalDate;

import com.hong.tms.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
  private Long mno;
  private String memberId;
  private String memberPw;
  private String memberPhone;
  private String memberCompany;
  private String memberVehicleType;
  private String memberVehicleNumber;
  private int memberType;

  private LocalDate createdAt;

  public MemberEntity toEntity() {
    return MemberEntity.builder()
        .memberId(this.memberId)
        .memberPw(this.memberPw)
        .memberPhone(this.memberPhone)
        .memberCompany(this.memberCompany)
        .memberVehicleType(this.memberVehicleType)
        .memberVehicleNumber(this.memberVehicleNumber)
        .build();
  }

  public MemberDTO(MemberEntity e) {
    this.mno = e.getMno();
    this.memberId = e.getMemberId();
    this.memberPw = e.getMemberPw();
    this.memberPhone = e.getMemberPhone();
    this.memberCompany = e.getMemberPhone();
    this.memberVehicleType = e.getMemberVehicleType();
    this.createdAt = e.getCreatedAt();
    this.memberType = e.getMemberType();
  }
}
