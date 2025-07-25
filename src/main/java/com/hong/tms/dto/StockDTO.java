package com.hong.tms.dto;

import com.hong.tms.entity.StockEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
  private Long sno;

  private String stockCode;

  private String stockName;

  private int stockCounts;

  private String stockPlace;

  private int stockDegree = 0;

  public StockEntity toEntity() {
    return StockEntity.builder()
        .stockCode(this.stockCode)
        .stockName(this.stockName)
        .stockCounts(this.stockCounts)
        .stockPlace(this.stockPlace)
        .stockDegree(this.stockDegree)
        .build();
  }

  public StockDTO(StockEntity e) {
    this.stockCode = e.getStockCode();
    this.stockName = e.getStockName();
    this.stockCounts = e.getStockCounts();
    this.stockPlace = e.getStockPlace();
    this.stockDegree = e.getStockDegree();
  }
}
