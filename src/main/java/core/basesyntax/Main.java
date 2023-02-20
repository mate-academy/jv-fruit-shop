package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.BalanceOperationImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ReturnOperationImpl;
import core.basesyntax.service.impl.SupplyOperationImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromCsvFile(INPUT_FILE_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operations = getHandlerMap();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> parsedTransactions = transactionParser.parse(data);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processTransactions(parsedTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_FILE_PATH, report);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> getHandlerMap() {
        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl(storageDao));
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl(storageDao));
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl(storageDao));
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl(storageDao));

        return operations;
    }
}
