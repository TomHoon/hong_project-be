package com.hong.tms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hong.tms.dto.StockDTO;
import com.hong.tms.entity.StockEntity;
import com.hong.tms.repository.StockRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockService {

  private final StockRepository stockRepository;

  // 전체조회
  public List<StockDTO> getStocks() {
    List<StockDTO> list = stockRepository.findAll().stream().map(e -> new StockDTO(e)).collect(Collectors.toList());
    return list;
  }

  // 등록
  public StockDTO registerStock(StockDTO dto) {
    StockEntity e = StockEntity
        .builder()
        .stockCode(dto.getStockCode())
        .stockName(dto.getStockName())
        .stockCounts(dto.getStockCounts())
        .stockPlace(dto.getStockPlace())
        .stockDegree(dto.getStockDegree())
        .stockPosition(dto.getStockPosition())
        .build();

    StockEntity result = stockRepository.save(e);
    return result.toDTO();
  }

  // 수정
  public StockDTO modifyStock(StockDTO dto) {
    Long id = dto.getSno();
    StockEntity e = stockRepository.findById(id).orElseThrow();
    e.update(dto);

    stockRepository.save(e);

    return dto;
  }

  // 삭제
  public Boolean deleteStock(Long sno) {
    stockRepository.deleteById(sno);

    return true;
  }
}
