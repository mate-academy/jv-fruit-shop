package core.basesyntax;

import core.basesyntax.dao.csv.CsvDao;
import core.basesyntax.dao.csv.impl.CsvDaoImpl;
import core.basesyntax.dao.storage.StorageDao;
import core.basesyntax.dao.storage.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.fruitshop.FruitShopService;
import core.basesyntax.service.fruitshop.impl.FruitShopServiceImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceOperationHandler;
import core.basesyntax.service.operation.impl.PurchaseOperationHandler;
import core.basesyntax.service.operation.impl.ReturnOperationHandler;
import core.basesyntax.service.operation.impl.SupplyOperationHandler;
import core.basesyntax.strategy.FruitShopStrategy;
import core.basesyntax.strategy.impl.FruitShopStrategyImpl;
import core.basesyntax.utils.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Work {
    private static FruitShopService fruitShopService;
    private static List<FruitTransaction> fruitTransactionList;
    private final FruitShopStrategy fruitShopStrategy;

    {
        StorageDao storageDao = new StorageDaoImpl();
        CsvDao csvDao = new CsvDaoImpl();
        fruitShopService = new FruitShopServiceImpl(storageDao, csvDao);
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler(fruitShopService));
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler(fruitShopService));
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitShopService));
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler(fruitShopService));
        fruitShopStrategy = new FruitShopStrategyImpl(operationHandlerMap);
        fruitTransactionList = fruitShopService.readAllFromCsv();

    }

    public static void main(String[] args) {
        Work work = new Work();
        work.startWork();
        fruitShopService.exportReport();
    }

    public void startWork() {
        fruitTransactionList.forEach(fruitTransaction -> fruitShopStrategy
                .get(fruitTransaction.getOperation())
                .operation(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
    }
}
