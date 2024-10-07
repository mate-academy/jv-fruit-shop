package core.basesyntax.strategy;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, FruitOperationHandler> fruitOperationHandlerMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, FruitOperationHandler> fruitOperationHandlerMap) {
        this.fruitOperationHandlerMap = fruitOperationHandlerMap;
    }

    @Override
    public FruitOperationHandler getHandler(FruitTransaction transaction, Inventory inventory) {
        FruitOperationHandler handler = fruitOperationHandlerMap.get(transaction.getOperation());
        if (handler != null) {
            handler.getFruitOperation(transaction, inventory);
        }
        return handler;
    }
}
