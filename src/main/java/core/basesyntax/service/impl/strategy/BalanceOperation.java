package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransactionDto fruitTransactionDto) {
        Storage.fruitStorage.put(fruitTransactionDto.fruit(), fruitTransactionDto.quantity());
    }
}
