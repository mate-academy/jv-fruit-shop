package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.FruitTransaction;
import service.ParserService;
import service.ReaderService;
import service.ReportService;
import service.TransactionService;
import service.WriterService;
import service.handler.BalanceOperationHandler;
import service.handler.OperationHandler;
import service.handler.PurchaseOperationHandler;
import service.handler.ReturnOperationHandler;
import service.handler.SupplyOperationHandler;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FILE_FROM_READ = "src/main/resources/input.csv";
    private static final String FILE_TO_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        ReaderService reader = new ReaderServiceImpl();
        List<String> inputStrings = reader.read(FILE_FROM_READ);

        ParserService parser = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parser.parse(inputStrings);

        TransactionService transactionService = new TransactionServiceImpl(operationStrategy);
        transactionService.executeOperation(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        WriterService writer = new WriterServiceImpl();
        writer.write(FILE_TO_WRITE,report);
    }
}
