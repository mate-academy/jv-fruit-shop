package core.basesyntax.service.implementations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.handlers.BalanceHandler;
import core.basesyntax.service.handlers.PurchaseHandler;
import core.basesyntax.service.handlers.ReturnHandler;
import core.basesyntax.service.handlers.SupplyHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {

    @Override
    public void process(List<FruitTransaction> fruitInfo) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        OperationHandler handler;

        for (FruitTransaction fruitTransaction : fruitInfo) {
            handler = strategy.get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
    }
}
