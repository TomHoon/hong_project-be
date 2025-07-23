package com.hong.tms.entity;

import com.hong.tms.dto.StockDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_stock")
@Builder
public class StockEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long sno;

 private String stockCode;

 private String stockName;

 private int stockCounts;

 private String stockPlace;

 @Builder.Default
 private int stockDegree = 0;

 public StockDTO toDTO() {
  return new StockDTO(sno, stockCode, stockName, stockCounts, stockPlace, stockDegree);
 }

 public void update(StockDTO dto) {
  this.stockCode = dto.getStockCode();
  this.stockName = dto.getStockName();
  this.stockCounts = dto.getStockCounts();
  this.stockPlace = dto.getStockPlace();
  this.stockDegree = dto.getStockDegree();
 }

}
