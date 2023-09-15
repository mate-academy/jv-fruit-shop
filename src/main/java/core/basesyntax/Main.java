package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.ParseTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.strategy.operations.BalanceOperation;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperation;
import core.basesyntax.strategy.operations.ReturnOperation;
import core.basesyntax.strategy.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String PATH_TO_CSV_FILE = "src/main/resources/inputFile.txt";
    private static final String PATH_TO_CSV_REPORT_FILE = "src/main/resources/recordFile.txt";
    private static final HashMap<Operation, OperationHandler>
            operationHandlersStrategy = new HashMap<>();

    static {
        operationHandlersStrategy.put(Operation.BALANCE, new BalanceOperation());
        operationHandlersStrategy.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlersStrategy.put(Operation.RETURN, new ReturnOperation());
        operationHandlersStrategy.put(Operation.SUPPLY, new SupplyOperation());
    }

    public static void main(String[] args) {
        ReaderServiceImpl reader = new ReaderServiceImpl();
        List<String> data = reader.readFromFile(PATH_TO_CSV_FILE);

        ParseTransactionServiceImpl parseService = new ParseTransactionServiceImpl();
        List<FruitTransaction> fruitTransactions = parseService.parseTransactions(data);

        TransactionProcessor transactionProcessor = new
                TransactionProcessor(operationHandlersStrategy);
        transactionProcessor.processTransactions(fruitTransactions);

        ReportCreatorImpl reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        WriterServiceImpl writerService = new WriterServiceImpl();
        writerService.writeToFile(PATH_TO_CSV_REPORT_FILE, report);
    }
}
