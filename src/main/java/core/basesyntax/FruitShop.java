package core.basesyntax;

import core.basesyntax.dao.WarehouseDaoReader;
import core.basesyntax.dao.WarehouseDaoWriter;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;
import core.basesyntax.service.WarehouseImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.handlers.OperationBalance;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.OperationPurchase;
import core.basesyntax.strategy.handlers.OperationReturn;
import core.basesyntax.strategy.handlers.OperationSupply;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private static final String INPUT_FILE = "input.csv";
    private static final String OUTPUT_FILE = "output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new OperationBalance());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new OperationPurchase());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new OperationReturn());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new OperationSupply());

        Strategy strategy = new StrategyImpl(operationHandlerMap);
        Warehouse warehouse = new WarehouseImpl(
                new WarehouseDaoReader().readData(INPUT_FILE), strategy);
        new WarehouseDaoWriter().writeData(OUTPUT_FILE, warehouse.getRemains());
    }

}
