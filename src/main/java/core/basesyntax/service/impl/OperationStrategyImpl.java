package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.models.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler getStrategy(FruitTransfer fruitLot) {
        OperationHandler handler = handlerMap.get(fruitLot.getAction());
        if (handler == null) {
            throw new RuntimeException("Invalid operation, check the title of operation "
                    + "'" + fruitLot.getAction() + "'");
        }
        return handler;
    }
}
