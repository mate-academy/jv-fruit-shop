package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        ReaderService fileReader = new ReaderServiceImpl();
        TransactionParser parser = new TransactionParserImpl();

        List<String> dataFromFile = fileReader.readFromFile(FILE_PATH);
        List<FruitTransaction> fruitTransactionList = parser.parse(dataFromFile);
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler handler = strategy.get(fruitTransaction.getOperation());
            handler.operate(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(REPORT_PATH, report);
    }
}
