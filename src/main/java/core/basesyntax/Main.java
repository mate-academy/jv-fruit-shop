package core.basesyntax;

import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.TransactionParserImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/java/resources/data.csv";
    private static final String REPORT_PATH = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        //
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReaderService readerService = new ReaderServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        //
        List<String> readedData = readerService.readFromFile(FILE_PATH);
        List<FruitTransaction> fruitTransactionsList = transactionParser.parse(readedData);
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }
        //
        String report = reportService.generate();
        writerService.writeToFile(REPORT_PATH, report);

    }
}
