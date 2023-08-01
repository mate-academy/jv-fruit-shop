package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerService;

public class BalanceHandler implements OperationHandlerService {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruit.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
