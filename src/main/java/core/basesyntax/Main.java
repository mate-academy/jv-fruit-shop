package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        TransactionParserService parser = new TransactionParserServiceImpl();
        FileWriterService writeService = new FileWriterServiceImpl();
        List<String> data = new FileReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactionList = parser.parseList(data);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        for (FruitTransaction result : transactionList) {
            OperationHandler operationHandler = operationStrategy.get(result.getOperation());
            operationHandler.handle(result);
        }
        ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
        String report = reportCreator.createReport();
        writeService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
