package core.basesyntax.service.implemantation;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.StrategyOperationImpl;
import java.util.List;
import java.util.Map;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final OperationStrategy strategyOperation;

    public TransactionExecutorImpl() {
        strategyOperation = new StrategyOperationImpl();
    }

    @Override
    public void processDate(List<FruitTransaction> data,
                            Map<Operation, OperationHandler> operationHandlerMap) {
        for (FruitTransaction fruitTransaction : data) {
            OperationHandler operationHandler = strategyOperation
                    .getOperation(fruitTransaction.getOperation(), operationHandlerMap);
            operationHandler.handle(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
