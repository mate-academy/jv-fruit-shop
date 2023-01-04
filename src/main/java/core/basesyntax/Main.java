package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FileService;
import service.OperationHandler;
import service.OperationStrategy;
import service.ReportService;
import service.impl.FileServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParseImpl;
import service.operations.BalanceOperationHandler;
import service.operations.PurchaseOperationHandler;
import service.operations.ReturnOperationHandler;
import service.operations.SupplyOperationHandler;

public class Main {
    public static final String FILE_NAME = "src/main/resources/Fruits.csv";
    public static final String FILE_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(Operation.BALANCE, new BalanceOperationHandler());
        strategies.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategies.put(Operation.SUPPLY, new SupplyOperationHandler());
        strategies.put(Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        FileService fileService = new FileServiceImpl();
        List<String> dataFromFile = fileService.read(FILE_NAME);
        List<FruitTransaction> transactionList = new TransactionParseImpl().parse(dataFromFile);

        for (FruitTransaction fruitTransaction : transactionList) {
            OperationHandler handler = operationStrategy
                    .get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();
        fileService.write(FILE_REPORT, report);
    }
}
