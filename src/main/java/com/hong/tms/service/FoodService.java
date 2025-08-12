package com.hong.tms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hong.tms.dto.FoodDTO;
import com.hong.tms.entity.FoodEntity;
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

  public FoodDTO getOneFood(Long fno) {
    return foodRepository
        .findById(fno)
        .orElseThrow()
        .toDTO();
  }

  public FoodDTO updateFood(FoodDTO dto) {
    FoodEntity e = foodRepository.findById(dto.getFno()).orElseThrow();
    e.updateFood(dto);

    foodRepository.save(e);

    return e.toDTO();
  }

  public FoodDTO registerFood(FoodDTO dto) {
    FoodEntity requestDTO = FoodEntity.builder()
        .foodImageUrl(dto.getFoodImageUrl())
        .title(dto.getTitle())
        .content(dto.getContent())
        .price(dto.getPrice())
        .foodDesc(dto.getFoodDesc())
        .build();

    FoodEntity e = foodRepository.save(requestDTO);

    return e.toDTO();
  }

  public FoodDTO deleteFood(Long fno) {
    FoodEntity e = foodRepository.findById(fno).orElseThrow();
    FoodDTO dto = e.toDTO();

    foodRepository.deleteById(fno);

    return dto;
  }
}
