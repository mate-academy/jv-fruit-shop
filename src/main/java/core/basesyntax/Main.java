package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculationService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.impl.CalculationServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import core.basesyntax.service.impl.CsvTransactionParserServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.strategy.transaction.BalanceTransactionHandlerImpl;
import core.basesyntax.strategy.transaction.PurchaseTransactionHandlerImpl;
import core.basesyntax.strategy.transaction.ReturnTransactionHandlerImpl;
import core.basesyntax.strategy.transaction.SupplyTransactionHandlerImpl;
import core.basesyntax.strategy.transaction.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandlerImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandlerImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandlerImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandlerImpl());

        FileReaderService csvFileReader = new CsvFileReaderServiceImpl();
        List<String> dataFromFile = csvFileReader.readFromFile(INPUT_FILE_NAME);

        TransactionParserService csvParserService = new CsvTransactionParserServiceImpl();
        List<FruitTransaction> fruitTransactionList = csvParserService.parse(dataFromFile);

        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(transactionHandlerMap);

        CalculationService calculationService = new CalculationServiceImpl(transactionStrategy);
        calculationService.calculate(fruitTransactionList);

        ReportService reportService = new CsvReportServiceImpl();
        String report = reportService.createReport(Storage.fruitsMap);

        FileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        fileWriterService.writeToFile(report, REPORT_FILE_NAME);
    }
}
