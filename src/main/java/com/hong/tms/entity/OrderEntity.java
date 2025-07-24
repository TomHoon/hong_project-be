package com.hong.tms.entity;

import com.hong.tms.dto.OrderDTO;

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
@Table(name = "tbl_order")
@Builder
public class OrderEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long ono;

 private String orderNo;

 private String orderName;

 private String orderStatus;

 private String orderDpt;

 private String orderDate;

 public OrderDTO toDTO() {
  return new OrderDTO(ono, orderNo, orderName, orderStatus, orderDpt, orderDate);
 }

 public void update(OrderDTO dto) {
  this.orderNo = dto.getOrderNo();
  this.orderName = dto.getOrderName();
  this.orderStatus = dto.getOrderStatus();
  this.orderDate = dto.getOrderDate();
  this.orderDpt = dto.getOrderDpt();
 }
}
