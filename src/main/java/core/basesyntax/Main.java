package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.transaction.BalanceHandler;
import core.basesyntax.service.transaction.OperationHandler;
import core.basesyntax.service.transaction.PurchaseHandler;
import core.basesyntax.service.transaction.ReturnHandler;
import core.basesyntax.service.transaction.SupplyHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String TRANSACTIONS_PATH = "src/main/java/resources/transactions.csv";
    private static final String REPORT_PATH = "src/main/java/resources/report.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        FruitStorageDao storageDao = new FruitStorageDaoImpl();
        ReaderService fileReaderService = new ReaderServiceImpl();
        List<String> strings = fileReaderService.readFromFile(TRANSACTIONS_PATH);

        ParserService parser = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parser.stringsToFruitTransactions(strings);

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(storageDao, operationStrategy);
        fruitTransactionService.processTransactions(fruitTransactions);

        ReportService fruitTransactionsReportService = new ReportServiceImpl();
        String report = fruitTransactionsReportService.createReport();

        WriterService fileWriterService = new WriterServiceImpl();
        fileWriterService.writeToFile(REPORT_PATH, report);
    }

    private static void fillMap() {
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
    }
}
