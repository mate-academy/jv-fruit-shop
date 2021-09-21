package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitShopService {
    Map<Fruit, Integer> transact(List<TransactionDto> transactionDtoList,
                                 OperationStrategy operationStrategy);
}
