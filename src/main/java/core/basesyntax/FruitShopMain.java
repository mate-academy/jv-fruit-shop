package core.basesyntax;

import core.basesyntax.model.Store;
import core.basesyntax.model.impl.FruitStoreImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class FruitShopMain {
    private static final String FILE_PATH = "src/main/resources/FruitShopMorningData.csv";
    private static final String FRUIT_REPORT_CSV = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        Store store = new FruitStoreImpl(operationStrategy);
        store.getInfo(FILE_PATH, FRUIT_REPORT_CSV);
    }
}
