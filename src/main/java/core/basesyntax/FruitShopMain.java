package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.implementations.DataProcessorImpl;
import core.basesyntax.service.implementations.FruitTransaction;
import core.basesyntax.service.implementations.OperationStrategyImpl;
import core.basesyntax.service.implementations.ReaderServiceImpl;
import core.basesyntax.service.implementations.ReportCreator;
import core.basesyntax.service.implementations.TransactionParser;
import core.basesyntax.service.implementations.WriterServiceImpl;
import core.basesyntax.service.operationhandler.BalanceOperationHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseOperationHandler;
import core.basesyntax.service.operationhandler.ReturnOperationHandler;
import core.basesyntax.service.operationhandler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class FruitShopMain {
    private static final String INPUT_FILE_PATH = "src/main/resources/dayInStore.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                                    new BalanceOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                                    new PurchaseOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                                    new ReturnOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                                    new SupplyOperationHandler());
        ReaderService readerService = new ReaderServiceImpl();
        TransactionParser transactionParser = new TransactionParser(
                readerService.readFromFile(INPUT_FILE_PATH));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        StorageDao storageDao = new StorageDaoImpl();
        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy, storageDao);
        dataProcessor.processData(transactionParser.getTransactionFromCsv());
        ReportCreator reportCreator = new ReportCreator(storageDao);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(reportCreator.provideReport(), OUTPUT_FILE_PATH);
    }
}
