package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.service.FruitTransactionStrategy;
import java.util.Map;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private final Map<FruitTransaction.Operation, FruitTransactionHandler> handlersMap;
    private final Storage storage;

    public FruitTransactionStrategyImpl(
            Map<FruitTransaction.Operation, FruitTransactionHandler> handlersMap,
            Storage storage
    ) {
        this.handlersMap = handlersMap;
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitTransactionHandler fruitTransactionHandler =
                handlersMap.get(fruitTransaction.getOperation());
        fruitTransactionHandler.handle(fruitTransaction, storage);
    }
}
