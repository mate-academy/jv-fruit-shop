package core.basesyntax;

import impl.OperationStrategyImpl;
import impl.ParseServiceImpl;
import impl.ReadServiceImpl;
import impl.ReportServiceImpl;
import impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ParseService;
import service.ReadService;
import service.ReportService;
import service.WriteService;
import strategy.BalanceHandler;
import strategy.OperationHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.SupplyHandler;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/database.csv";
    private static final String REPORT_FILE_PATH = "src/main/java/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        List<String> dataFromFile = readService.read(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = parseService.parse(dataFromFile);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(REPORT_FILE_PATH, report);
    }
}
