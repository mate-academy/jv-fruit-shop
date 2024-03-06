package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.TransactionProcessorService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.FruitReportGeneratorService;
import core.basesyntax.service.impl.FruitTransactionParserService;
import core.basesyntax.service.impl.FruitTransactionProcessorService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy fruitOperationStrategy = new OperationStrategy(operationStrategies);

        FileReaderService fileCsvReader = new CsvFileReaderService();
        List<String> linesFromFile = fileCsvReader.readFromFile("src/main/resources/data.csv");

        TransactionParserService transactionParser = new FruitTransactionParserService();
        List<FruitTransaction> transactions = transactionParser.parseTransactions(linesFromFile);

        TransactionProcessorService transactionProcessor =
                new FruitTransactionProcessorService(fruitOperationStrategy);
        transactionProcessor.processTransactions(transactions);

        ReportGeneratorService reportGenerator = new FruitReportGeneratorService();
        String report = reportGenerator.generateReport();

        FileWriterService reportCsvWriter = new CsvFileWriterService();
        reportCsvWriter.writeToFile("src/main/resources/report.csv", report);
    }
}
