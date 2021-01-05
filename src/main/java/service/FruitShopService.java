package service;

import java.util.List;
import java.util.Map;
import model.Fruit;
import model.FruitTransactionDto;

public interface FruitShopService {

    void applyOperationsOnFruitsDto(List<FruitTransactionDto> dto);

    Map<Fruit, Integer> getFruitReport();
}
