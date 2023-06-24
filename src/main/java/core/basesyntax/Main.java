package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportServiceImpl;
import core.basesyntax.serviceimpl.TransactionsServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.OperationHandlerBalance;
import core.basesyntax.strategy.operation.OperationHandlerPurchase;
import core.basesyntax.strategy.operation.OperationHandlerReturn;
import core.basesyntax.strategy.operation.OperationHandlerSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/Input_file.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/Output_file.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler>
                operationOperationHandlerMap = new HashMap<>();
        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new OperationHandlerBalance());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationHandlerSupply());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationHandlerPurchase());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new OperationHandlerReturn());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromInputFile = readerService.readFromFile(PATH_TO_INPUT_FILE);

        TransactionService transactionService = new TransactionsServiceImpl();
        List<FruitTransaction> listOfFruitTransactions =
                transactionService.getlistOfFruitTransaction(dataFromInputFile);

        OperationStrategyImpl operationStrategy =
                new OperationStrategyImpl(operationOperationHandlerMap);
        for (FruitTransaction fruitTransaction : listOfFruitTransactions) {
            OperationHandler operationHandler =
                    operationStrategy.getOperation(fruitTransaction.getOperation());
            operationHandler.operation(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String dataToWtite = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(dataToWtite, PATH_TO_OUTPUT_FILE);
    }
}
