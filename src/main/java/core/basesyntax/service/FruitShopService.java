package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitShopService {
    void applyOperationoOnFruitsDto(List<TransactionDto> transactionDtos);

    Map<Fruit, Integer> getFruitsReport();
}
