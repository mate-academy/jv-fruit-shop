package core.basesyntax;

import core.basesyntax.model.Store;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE.getText(), new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE.getText(), new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY.getText(), new SupplyOperationHandler());
        operationHandlerMap.put(Operation.RETURN.getText(), new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        Store store = new Store(operationStrategy);
        store.showStatistic("test6.csv", "result6.csv");
    }
}
