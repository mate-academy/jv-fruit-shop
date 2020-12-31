package core.basesyntax;

import core.basesyntax.model.Store;
import core.basesyntax.model.StoreImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
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

        Store store = new StoreImpl(operationStrategy);
        store.getStatistic("src\\test.csv");
    }
}
