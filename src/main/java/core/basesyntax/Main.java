package core.basesyntax;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.impl.BalanceHandler;
import core.basesyntax.operation.impl.PurchaseHandler;
import core.basesyntax.operation.impl.ReturnHandler;
import core.basesyntax.operation.impl.SupplyHandler;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionServiseImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE = "src/main/resources/inputFile.csv";
    private static final String WRITE_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationOperationHandlerMap =
                new HashMap<>();
        operationOperationHandlerMap.put(Operation.BALANCE,
                new BalanceHandler());
        operationOperationHandlerMap.put(Operation.SUPPLY,
                new SupplyHandler());
        operationOperationHandlerMap.put(Operation.PURCHASE,
                new PurchaseHandler());
        operationOperationHandlerMap.put(Operation.RETURN,
                new ReturnHandler());
        FileReader readerService = new FileReaderImpl();
        List<String> dataFromInputFile = readerService.readData(READ_FILE);

        TransactionService transactionService = new TransactionServiseImpl();
        List<FruitsTranslation> listOfFruitTransactions =
                transactionService.transactionProcess(dataFromInputFile);

        OperationStrategyImpl operationStrategy =
                new OperationStrategyImpl(operationOperationHandlerMap);
        for (FruitsTranslation fruitTransaction : listOfFruitTransactions) {
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.getOperationResult(fruitTransaction);
        }

        ReportCreator reportService = new ReportCreatorImpl();
        String report = reportService.doReport();

        FileWriter writerService = new FileWriterImpl();
        writerService.writeData(report, WRITE_FILE);
    }
}
