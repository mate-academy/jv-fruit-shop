package core.basesyntax.app;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "src/main/resources/input.csv";
        final String outputFilePath = "src/main/resources/output.csv";
        Reader reader = new CsvReader();
        final List<String> inputData = reader.read(inputFilePath);
        Map<String, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put("b", new BalanceHandler());
        operationHandlers.put("s", new SupplyHandler());
        operationHandlers.put("p", new PurchaseHandler());
        operationHandlers.put("r", new ReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        TransactionParser transactionParser = new TransactionParser();
        TransactionProcessor transactionProcessor =
                new TransactionProcessor(operationStrategy, transactionParser);
        transactionProcessor.processTransactions(inputData);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> reportData = reportGenerator.generateReport();
        Writer writer = new CsvWriter();
        writer.write(reportData, outputFilePath);
        System.out.println("Fruit shop report generated successfully!");
    }
}
