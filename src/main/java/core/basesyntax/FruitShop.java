package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitReportGenerator;
import core.basesyntax.service.impl.FruitTransactionParser;
import core.basesyntax.service.impl.FruitTransactionProcessor;
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

        FileReader fileCsvReader = new FileReaderImpl();
        List<String> linesFromFile = fileCsvReader.readFromFile("src/main/resources/data.csv");

        TransactionParser transactionParser = new FruitTransactionParser();
        List<FruitTransaction> transactions = transactionParser.parseAll(linesFromFile);

        TransactionProcessor transactionProcessor =
                new FruitTransactionProcessor(fruitOperationStrategy);
        transactionProcessor.processAll(transactions);

        ReportGenerator reportGenerator = new FruitReportGenerator();
        String report = reportGenerator.generateReport();

        FileWriter reportCsvWriter = new FileWriterImpl();
        reportCsvWriter.writeToFile("src/main/resources/report.csv", report);
    }
}
