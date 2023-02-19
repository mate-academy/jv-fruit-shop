package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;
import core.basesyntax.service.*;
import core.basesyntax.serviceImpl.FileServiceImpl;
import core.basesyntax.serviceImpl.OperationStrategyImpl;
import core.basesyntax.serviceImpl.ReportServiceImpl;
import core.basesyntax.serviceImpl.TransactionParserImpl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/resources/inputdata.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/resources/outputdata.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> dateFromFile = fileService.read(INPUT_FILE_PATH);
        TransactionParser transactionParser = new TransactionParserImpl();

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE,new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE,new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY,new SupplyOperationHandler());
        operationHandlerMap.put(Operation.RETURN,new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = transactionParser.parse(dateFromFile);
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        fileService.write(OUTPUT_FILE_PATH,report);
        System.out.println(fileService.read(OUTPUT_FILE_PATH));
    }
}

