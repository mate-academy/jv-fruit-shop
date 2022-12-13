import model.FruitTransaction;
import service.*;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionParserImpl;
import service.strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruitList = fileReaderService.readFromFile("file.csv");

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactionList = transactionParser.parseAll(fruitList);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report);
    }
}
