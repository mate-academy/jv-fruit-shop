package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitShopStrategy;
import core.basesyntax.strategy.FruitTransactionHandler;
import java.util.Map;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private final Map<FruitTransaction.Operation, FruitTransactionHandler> handlersMap;

    public FruitShopStrategyImpl(
            Map<FruitTransaction.Operation, FruitTransactionHandler> handlersMap
    ) {
        this.handlersMap = handlersMap;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitTransactionHandler fruitTransactionHandler =
                handlersMap.get(fruitTransaction.getOperation());
        fruitTransactionHandler.handle(fruitTransaction);
    }
}
