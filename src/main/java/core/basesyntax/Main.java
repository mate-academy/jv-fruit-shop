package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.CsvTransactionParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.handler.OperationHandler;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final File INPUT_FILE = new File("src/main/resources/database.csv");
    private static final File REPORT = new File("src/main/resources/report.csv");

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler>
                operationOperationStrategyMap = new HashMap<>();
        operationOperationStrategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationOperationStrategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationOperationStrategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationOperationStrategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy strategy = new OperationStrategyImpl(operationOperationStrategyMap);
        FileReader report = new FileReaderImpl();
        TransactionParser transactionParser = new CsvTransactionParserImpl();
        List<String> dataFromFile = report.readReport(INPUT_FILE);
        List<FruitTransaction> fruitTransactions = transactionParser.parseReport(dataFromFile);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = strategy
                    .getHandler(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String reportText = reportService.createReportText();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReportToFile(reportText, REPORT);
    }
}
