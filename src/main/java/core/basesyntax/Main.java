package core.basesyntax;

import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvReportServiceImpl;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.TransactionProcessorImpl;
import core.basesyntax.service.TransitionConvertorImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperationHandler;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperationHandler;
import core.basesyntax.strategy.operations.ReturnOperationHandler;
import core.basesyntax.strategy.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";
    private static final String BALANCE_FILE_NAME = "src/main/resources/database.csv";

    public static void main(String[] args) {
        TransactionProcessor transactionProcessor =
                new TransactionProcessorImpl(new
                        OperationStrategyImpl(createOperationHandlerMap()));
        List<String> stringsFromFile = new FileReaderImpl()
                .readFromFile(BALANCE_FILE_NAME);
        List<Transaction> transactionsFromFile = new TransitionConvertorImpl()
                .convert(stringsFromFile);
        transactionProcessor.process(transactionsFromFile);
        String report = new CsvReportServiceImpl().makeReport();
        new FileWriterImpl().writeToFile(PIVOT_FILE_NAME, report);
    }

    private static Map<Operation, OperationHandler> createOperationHandlerMap() {
        HashMap<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        return operationHandlerMap;
    }
}
