package service;

import model.FruitTransactionDto;

import java.util.List;

public interface FruitShopService {
    void applyOperationsOnFruitsDto(List<FruitTransactionDto> dto);
}
