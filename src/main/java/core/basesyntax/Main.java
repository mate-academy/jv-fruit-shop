package core.basesyntax;

import core.basesyntax.model.Store;
import core.basesyntax.model.impl.FruitStoreImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.io.File;
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

        Store store = new FruitStoreImpl(operationStrategy);
        store.getStatistic("src" + File.separator + "test2.csv", "src" + File.separator
                + "result1.csv");
        store.getStatistic("src" + File.separator + "test1.csv", "");
    }
}
