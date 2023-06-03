package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseTextService;
import core.basesyntax.service.ReadReportService;
import core.basesyntax.service.WriteReportToFileService;
import core.basesyntax.service.impl.ParseTextServiceImpl;
import core.basesyntax.service.impl.ReadReportServiceImpl;
import core.basesyntax.service.impl.WriteReportToFileServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import core.basesyntax.service.CreateReportTextService;
import core.basesyntax.service.impl.CreateReportTextServiceImpl;
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
