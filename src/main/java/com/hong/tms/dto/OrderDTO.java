package com.hong.tms.dto;

import com.hong.tms.entity.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
  private Long ono;

  private String orderNo;

  private String orderName;

  private String orderStatus;

  private String orderDate;

  public OrderEntity toEntity() {
    return OrderEntity.builder()
        .orderNo(this.orderNo)
        .orderName(this.orderName)
        .orderStatus(this.orderStatus)
        .orderDate(this.orderDate)
        .build();
  }

  public OrderDTO(OrderEntity e) {
    this.orderNo = e.getOrderNo();
    this.orderName = e.getOrderName();
    this.orderStatus = e.getOrderStatus();
    this.orderDate = e.getOrderDate();
  }
}
