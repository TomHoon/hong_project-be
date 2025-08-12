package com.hong.tms.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import com.hong.tms.dto.FoodDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_food")
public class FoodEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long fno;

  private String foodImageUrl;

  private String title;

  private String content;

  private String price;

  private String foodDesc;

  @CreatedDate
  private LocalDate createdAt;

  public FoodDTO toDTO() {
    return new FoodDTO(this);
  }

  public void updateFood(FoodDTO dto) {
    if (dto.getFoodImageUrl() != null)
      this.foodImageUrl = dto.getFoodImageUrl();
    if (dto.getTitle() != null)
      this.title = dto.getTitle();
    if (dto.getContent() != null)
      this.content = dto.getContent();
    if (dto.getPrice() != null)
      this.price = dto.getPrice();
    if (dto.getFoodDesc() != null)
      this.foodDesc = dto.getFoodDesc();
  }

}
