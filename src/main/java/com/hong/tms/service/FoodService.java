package com.hong.tms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hong.tms.dto.FoodDTO;
import com.hong.tms.repository.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodService {

  private final FoodRepository foodRepository;

  public List<FoodDTO> getFoods() {
    return foodRepository.findAll()
        .stream()
        .map(e -> new FoodDTO(e))
        .collect(Collectors.toList());
  }
}
