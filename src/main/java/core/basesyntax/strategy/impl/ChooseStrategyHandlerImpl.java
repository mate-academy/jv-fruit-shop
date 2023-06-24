package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ChooseStrategyHandler;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class ChooseStrategyHandlerImpl implements ChooseStrategyHandler {
    private final Map<FruitTransaction.Operation, OperationHandler> mapOfOperations;

    public ChooseStrategyHandlerImpl(Map<FruitTransaction.Operation,
            OperationHandler> mapOfOperations) {
        this.mapOfOperations = mapOfOperations;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction fruitTransaction) {
        return mapOfOperations.get(fruitTransaction.getOperation());
    }
}
