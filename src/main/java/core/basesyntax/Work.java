package core.basesyntax;

import core.basesyntax.dao.csv.CsvFileHandlerDao;
import core.basesyntax.dao.csv.impl.CsvFileHandlerDaoImpl;
import core.basesyntax.dao.storage.FruitStorageDao;
import core.basesyntax.dao.storage.impl.FruitStorageDaoImpl;
import core.basesyntax.db.Storage;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Work {

    public static void main(String[] args) {
        String readFilePath = "src/main/java/core/basesyntax/csv/database.csv";
        String writeFilePath = "src/main/java/core/basesyntax/csv/report.csv";
        Storage storage = new Storage();
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl(storage);
        CsvFileHandlerDao csvFileHandlerDao = new CsvFileHandlerDaoImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(
                readFilePath, writeFilePath, fruitStorageDao, csvFileHandlerDao);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(
                FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitShopService));
        operationHandlerMap.put(
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitShopService));
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitShopService));
        operationHandlerMap.put(
                FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitShopService));
        FruitShopStrategy fruitShopStrategy = new FruitShopStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = fruitShopService.readAllFromCsv();

        startWork(fruitTransactionList, fruitShopStrategy);
        fruitShopService.exportReport();
    }

    public static void startWork(List<FruitTransaction> fruitTransactionList,
                                 FruitShopStrategy fruitShopStrategy) {
        fruitTransactionList.forEach(fruitTransaction -> fruitShopStrategy
                .get(fruitTransaction.getOperation())
                .operation(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
    }
}
