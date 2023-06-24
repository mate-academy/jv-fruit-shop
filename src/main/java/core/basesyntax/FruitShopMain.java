package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.FileService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.implementations.FileServiceImpl;
import core.basesyntax.service.implementations.FruitTransaction;
import core.basesyntax.service.implementations.OperationStrategyImpl;
import core.basesyntax.service.implementations.ReportCreator;
import core.basesyntax.service.implementations.TransactionParser;
import core.basesyntax.service.implementations.TransactionProcessorImpl;
import core.basesyntax.service.operationhandler.BalanceOperationHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseOperationHandler;
import core.basesyntax.service.operationhandler.ReturnOperationHandler;
import core.basesyntax.service.operationhandler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopMain {
    private static final String INPUT_FILE_PATH = "src/main/resources/dayInStore.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                                    new BalanceOperationHandler(storageDao));
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                                    new PurchaseOperationHandler(storageDao));
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                                    new ReturnOperationHandler(storageDao));
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                                    new SupplyOperationHandler(storageDao));
        FileService fileService = new FileServiceImpl();
        TransactionParser transactionParser = new TransactionParser();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        TransactionProcessor transactionProcessor =
                new TransactionProcessorImpl(operationStrategy);
        List<FruitTransaction> fruitTransactions =
                transactionParser.parseTransactions(fileService.readFromFile(INPUT_FILE_PATH));
        transactionProcessor.processData(fruitTransactions);
        ReportCreator reportCreator = new ReportCreator(storageDao);
        fileService.writeToFile(reportCreator.provideReport(storageDao.getAll()), OUTPUT_FILE_PATH);
    }
}
