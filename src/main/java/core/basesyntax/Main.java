package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.FruitTransaction;
import services.ParserService;
import services.ReaderService;
import services.ReportService;
import services.TransactionService;
import services.WriterService;
import services.impl.ParserServiceImpl;
import services.impl.ReaderServiceImpl;
import services.impl.ReportServiceImpl;
import services.impl.TransactionServiceImpl;
import services.impl.WriterServiceImpl;
import services.operationhandler.BalanceOperationHandler;
import services.operationhandler.OperationHandler;
import services.operationhandler.PurchaseOperationHandler;
import services.operationhandler.ReturnOperationHandler;
import services.operationhandler.SupplyOperationHandler;
import strategies.OperationStrategy;
import strategies.OperationStrategyImpl;

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
