package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;
import core.basesyntax.service.FileService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputdata.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputdata.csv";

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

