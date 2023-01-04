package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FileService;
import service.OperationHandle;
import service.OperationStrategy;
import service.ReportService;
import service.impl.FileServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParseImpl;
import service.operations.BalanceOperationImpl;
import service.operations.PurchaseOperationImpl;
import service.operations.ReturnOperationImpl;
import service.operations.SupplyOperationImpl;

public class Main {
    public static final String FILE_NAME = "src/main/resources/Fruits.csv";
    public static final String FILE_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandle> strategies = new HashMap<>();
        strategies.put(Operation.BALANCE, new BalanceOperationImpl());
        strategies.put(Operation.PURCHASE, new PurchaseOperationImpl());
        strategies.put(Operation.SUPPLY, new SupplyOperationImpl());
        strategies.put(Operation.RETURN, new ReturnOperationImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        FileService fileService = new FileServiceImpl();
        List<String> dataFromFile = fileService.read(FILE_NAME);
        List<FruitTransaction> transactionList = new TransactionParseImpl().parse(dataFromFile);

        for (FruitTransaction fruitTransaction : transactionList) {
            OperationHandle handler = operationStrategy
                    .get(fruitTransaction.getOperation());
            handler.operation(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report();
        fileService.write(FILE_REPORT, report);
    }
}
