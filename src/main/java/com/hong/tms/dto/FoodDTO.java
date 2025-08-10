package com.hong.tms.dto;

import java.time.LocalDate;

import com.hong.tms.entity.FoodEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDTO {

  private Long fno;
  private String foodImageUrl;

  private String title;

  private String content;

  private String price;

  private String foodDesc;

  private LocalDate createdAt;

  public FoodEntity toEntity() {
    return FoodEntity.builder()
        .foodImageUrl(this.foodImageUrl)
        .title(this.title)
        .content(this.content)
        .price(this.price)
        .foodDesc(this.foodDesc)
        .build();
  }

  public FoodDTO(FoodEntity e) {
    this.fno = e.getFno();
    this.foodImageUrl = e.getFoodImageUrl();
    this.title = e.getTitle();
    this.content = e.getContent();
    this.price = e.getPrice();
    this.foodDesc = e.getFoodDesc();
    this.createdAt = e.getCreatedAt();
  }

}
