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
import core.basesyntax.service.impl.TransactionCsvParserServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.strategy.transaction.BalanceTransactionHandler;
import core.basesyntax.strategy.transaction.PurchaseTransactionHandler;
import core.basesyntax.strategy.transaction.ReturnTransactionHandler;
import core.basesyntax.strategy.transaction.SupplyTransactionHandler;
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
                new BalanceTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());

        FileReaderService readerService = new CsvFileReaderServiceImpl();
        TransactionParserService transactionParserService = new TransactionCsvParserServiceImpl();
        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(transactionHandlerMap);
        CalculationService calculationService = new CalculationServiceImpl(transactionStrategy);
        ReportService reportService = new CsvReportServiceImpl();
        FileWriterService writerService = new CsvFileWriterServiceImpl();

        List<String> readFromFile = readerService.readFromFile(INPUT_FILE_NAME);
        List<FruitTransaction> parseData = transactionParserService.parse(readFromFile);
        calculationService.calculate(parseData);
        String report = reportService.createReport(Storage.fruitMap);
        writerService.writeToFile(report, REPORT_FILE_NAME);
    }
}
