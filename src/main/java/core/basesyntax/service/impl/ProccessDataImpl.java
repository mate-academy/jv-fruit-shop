package core.basesyntax.service.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProccessData;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class ProccessDataImpl implements ProccessData {

    private static final OperationStrategyImpl operationStrategyImpl = new OperationStrategyImpl();

    @Override
    public void handleOperations(List<FruitTransaction> fruitTransactions,
                                 Map<FruitTransaction.Operation, OperationHandler> mapOfHandler) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategyImpl
                    .getOperationHandler(fruitTransaction, mapOfHandler);
            operationHandler.handleOperation(fruitTransaction);
        }
    }
}
