package core.basesyntax;

import core.basesyntax.model.Store;
import core.basesyntax.service.StoreReadCsv;
import core.basesyntax.service.StoreReadCsvImpl;
import core.basesyntax.service.StoreWriteToFileCsv;
import core.basesyntax.service.StoreWriteToFileCsvImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.operation.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_NAME = "FILE_NAME";
    public static void main(String[] args) {

        StoreReadCsv reader = new StoreReadCsvImpl();
        reader.read(FILE_NAME);

        Map<Store.Operation, Handler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Store.Operation.BALANCE, new QuantityOperation());
        operationHandlerMap.put(Store.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Store.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Store.Operation.SUPPLY, new SupplyOperation());

        Strategy storeStrategy = new StrategyImpl(operationHandlerMap);


        StoreWriteToFileCsv write = new StoreWriteToFileCsvImpl();





    }
}
