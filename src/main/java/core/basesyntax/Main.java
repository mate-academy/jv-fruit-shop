package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    private static final String SOURCE_FILE_PATH = "src/main/java/core/basesyntax/resource/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/java/core/basesyntax/resource/report.csv";
    private static final StorageDao storageDao = new StorageDaoImpl();
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final TransactionService transactionService = new TransactionServiceImpl();


    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> fruitServiceMap = new HashMap<>();
        fruitServiceMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        fruitServiceMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        fruitServiceMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        fruitServiceMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        List<String> rawDataFromFile = fileReaderService.read(SOURCE_FILE_PATH);
        List<FruitTransaction> fruitsTransactionList = transactionService.processData(rawDataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitServiceMap);
        FruitService fruitService = new FruitServiceImpl(storageDao, operationStrategy);
        fruitService.setDataToStorage(fruitsTransactionList);
        List<Fruit> fruitsFromStorage = storageDao.getAll();
        fileWriterService.write(REPORT_FILE_PATH, fruitsFromStorage);
    }
}
