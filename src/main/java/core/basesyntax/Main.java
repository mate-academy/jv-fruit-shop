package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileWritter;
import core.basesyntax.dao.ReportCreator;
import core.basesyntax.dao.impl.FileReaderImpl;
import core.basesyntax.dao.impl.FileWritterImpl;
import core.basesyntax.dao.impl.ReportCreatorImpl;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.BalanceHandler;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseHandler;
import core.basesyntax.service.impl.ReturnHandler;
import core.basesyntax.service.impl.SupplyHandler;
import core.basesyntax.service.impl.TransactionServiseImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE = "src/main/resources/inputFile.csv";
    private static final String WRITE_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        Map<FruitsTranslation.Operation, OperationHandler>
                operationOperationHandlerMap = new HashMap<>();
        operationOperationHandlerMap.put(FruitsTranslation.Operation.BALANCE,
                new BalanceHandler());
        operationOperationHandlerMap.put(FruitsTranslation.Operation.SUPPLY,
                new SupplyHandler());
        operationOperationHandlerMap.put(FruitsTranslation.Operation.PURCHASE,
                new PurchaseHandler());
        operationOperationHandlerMap.put(FruitsTranslation.Operation.RETURN,
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
        String dataToWtite = reportService.doReport();

        FileWritter writerService = new FileWritterImpl();
        writerService.writeData(dataToWtite, WRITE_FILE);
    }
}
