package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.strategy.operations.BalanceOperationHandler;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperationHandler;
import core.basesyntax.strategy.operations.ReturnOperationHandler;
import core.basesyntax.strategy.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String PATH_TO_CSV_INPUT_FILE = "src/main/resources/inputFile.txt";
    private static final String PATH_TO_CSV_REPORT_FILE = "src/main/resources/recordFile.txt";
    private static final HashMap<Operation, OperationHandler>
            operationHandlersStrategy = new HashMap<>();

    static {
        operationHandlersStrategy.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlersStrategy.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlersStrategy.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlersStrategy.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        List<String> data = reader.readFromFile(PATH_TO_CSV_INPUT_FILE);

        ParseTransactionService parseService = new ParseTransactionServiceImpl();
        List<FruitTransaction> fruitTransactions = parseService.parseTransactions(data);

        TransactionProcessor transactionProcessor = new
                TransactionProcessor(operationHandlersStrategy);
        transactionProcessor.processTransactions(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(PATH_TO_CSV_REPORT_FILE, report);
    }
}
