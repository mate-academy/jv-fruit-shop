package core.basesyntax;

import core.basesyntax.dao.WarehouseDaoRead;
import core.basesyntax.dao.WarehouseDaoWrite;
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
        Map<FruitTransaction.Operation, OperationHandler> hendlerMap = new HashMap<>();
        hendlerMap.put(FruitTransaction.Operation.BALANCE, new OperationBalance());
        hendlerMap.put(FruitTransaction.Operation.PURCHASE, new OperationPurchase());
        hendlerMap.put(FruitTransaction.Operation.RETURN, new OperationReturn());
        hendlerMap.put(FruitTransaction.Operation.SUPPLY, new OperationSupply());

        Strategy strategy = new StrategyImpl(hendlerMap);
        Warehouse warehouse = new WarehouseImpl(
                new WarehouseDaoRead().readData(INPUT_FILE), strategy);
        new WarehouseDaoWrite().writeData(OUTPUT_FILE, warehouse.getRemains());
    }

}
