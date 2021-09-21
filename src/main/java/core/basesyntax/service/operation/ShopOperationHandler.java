package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public interface ShopOperationHandler {
    Map<Fruit, Integer> getOperationResult(TransactionDto transactionDto);
}
