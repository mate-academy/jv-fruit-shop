package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriteService;
import core.basesyntax.serviceimpl.OperationStrategyImpl;
import core.basesyntax.serviceimpl.ReadServiceImpl;
import core.basesyntax.serviceimpl.ReportServiceImpl;
import core.basesyntax.serviceimpl.TransactionParserImpl;
import core.basesyntax.serviceimpl.WriteServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

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
