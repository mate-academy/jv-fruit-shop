package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.service.FileReader;
import fruitshop.service.FileWriter;
import fruitshop.service.ReportService;
import fruitshop.service.TransactionParser;
import fruitshop.service.impl.CsvTransactionParserImpl;
import fruitshop.service.impl.FileReaderImpl;
import fruitshop.service.impl.FileWriterImpl;
import fruitshop.service.impl.ReportServiceImpl;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.OperationStrategyImpl;
import fruitshop.strategy.handler.BalanceOperationHandler;
import fruitshop.strategy.handler.OperationHandler;
import fruitshop.strategy.handler.PurchaseOperationHandler;
import fruitshop.strategy.handler.ReturnOperationHandler;
import fruitshop.strategy.handler.SupplyOperationHandler;
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
                    .getStrategy(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String reportText = reportService.createReportText();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReportToFile(reportText, REPORT);
    }
}
