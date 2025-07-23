package com.hong.tms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hong.tms.dto.OrderDTO;
import com.hong.tms.entity.OrderEntity;
import com.hong.tms.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  // 전체조회
  public List<OrderDTO> getAll() {
    List<OrderDTO> list = orderRepository.findAll()
        .stream()
        .map(e -> new OrderDTO(e))
        .collect(Collectors.toList());

    return list;

  }

  // 등록
  public OrderDTO registerOrder(OrderDTO dto) {
    OrderEntity e = dto.toEntity();
    OrderEntity result = orderRepository.save(e);
    return result.toDTO();
  }

  // 수정
  public OrderDTO modifyOrder(OrderDTO dto) {
    OrderEntity e = orderRepository.findById(dto.getOno()).orElseThrow();
    e.update(dto);
    return orderRepository.save(e).toDTO();
  }

  // 삭제
  public Boolean deleteOrder(Long ono) {
    orderRepository.deleteById(ono);

    return true;
  }
}
