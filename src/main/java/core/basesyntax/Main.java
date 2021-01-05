package core.basesyntax;

import core.basesyntax.model.Store;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        Store store = new Store(operationStrategy);
        store.showStatistic("test2.csv", "result2.csv");
        store.showStatistic("test1.csv", "");
    }
}
