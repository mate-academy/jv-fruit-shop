package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.service.CreateReportTextService;
import fruitshop.service.ParseTextService;
import fruitshop.service.ReadReportService;
import fruitshop.service.WriteReportToFileService;
import fruitshop.service.impl.CreateReportTextServiceImpl;
import fruitshop.service.impl.ParseTextServiceImpl;
import fruitshop.service.impl.ReadReportServiceImpl;
import fruitshop.service.impl.WriteReportToFileServiceImpl;
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
        ReadReportService report = new ReadReportServiceImpl();
        ParseTextService parseTextService = new ParseTextServiceImpl();
        List<String> dataFromFile = report.readReport(INPUT_FILE);
        List<FruitTransaction> fruitTransactions = parseTextService.parseReport(dataFromFile);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = strategy
                    .getStrategy(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }
        CreateReportTextService createReportTextService = new CreateReportTextServiceImpl();
        String reportText = createReportTextService.createReportText();
        WriteReportToFileService writeReportToFileService = new WriteReportToFileServiceImpl();
        writeReportToFileService.writeReportToFile(reportText, REPORT);
    }
}
