package core.basesyntax;

import core.basesyntax.operation.BalanceHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseHandler;
import core.basesyntax.operation.ReturnHandler;
import core.basesyntax.operation.SupplyHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransactionImpl.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransactionImpl.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransactionImpl.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransactionImpl.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransactionImpl.Operation.SUPPLY, new SupplyHandler());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransaction fruitTransaction = new FruitTransactionImpl(strategy);
        List<String> dayStatistics = fruitTransaction.getDayData();
        fruitTransaction.processData(dayStatistics);
        String report = fruitTransaction.generateReport();
        fruitTransaction.writeData(report);
    }
}
