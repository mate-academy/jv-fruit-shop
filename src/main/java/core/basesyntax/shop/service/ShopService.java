package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void applyOperationOnFruitsDto(List<TransactionDto> transactionDtos);

    Map<Fruit, Integer> getFruitReport();
}
