package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;
import core.basesyntax.services.OperationStrategy;
import core.basesyntax.services.ReadService;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.TransactionParser;
import core.basesyntax.services.WriteService;
import core.basesyntax.servicesimpl.OperationStrategyImpl;
import core.basesyntax.servicesimpl.ReadServiceImpl;
import core.basesyntax.servicesimpl.ReportServiceImpl;
import core.basesyntax.servicesimpl.TransactionParserImpl;
import core.basesyntax.servicesimpl.WriteServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/core/basesyntax/files/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/java/core/basesyntax/files/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        TransactionParser parser = new TransactionParserImpl();
        List<String> dataFromFile = readService.read(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = parser.parse(dataFromFile);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriteService writerService = new WriteServiceImpl();
        writerService.writeToFile(REPORT_FILE_PATH, report);
    }
}
