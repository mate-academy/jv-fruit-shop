package core.basesyntax;

import core.basesyntax.dao.WarehouseDaoRead;
import core.basesyntax.dao.WarehouseDaoWrite;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Warehouse;
import core.basesyntax.service.WarehouseImpl;
import core.basesyntax.stretegy.Strategy;
import core.basesyntax.stretegy.StrategyImpl;
import core.basesyntax.stretegy.handlers.*;

import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private static final String INPUT_FILE = "input.csv";
    private static final String OUTPUT_FILE = "output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler > hendlerMap = new HashMap<>();
        hendlerMap.put(FruitTransaction.Operation.BALANCE, new OperationBalance());
        hendlerMap.put(FruitTransaction.Operation.PURCHASE, new OperationPurchase());
        hendlerMap.put(FruitTransaction.Operation.RETURN, new OperationReturn());
        hendlerMap.put(FruitTransaction.Operation.SUPPLY, new OperationSupply());

        Strategy strategy = new StrategyImpl(hendlerMap);
        Warehouse warehouse = new WarehouseImpl(WarehouseDaoRead.readData(INPUT_FILE), strategy);
        WarehouseDaoWrite.writeData(OUTPUT_FILE, warehouse.getRemains());
    }

}
