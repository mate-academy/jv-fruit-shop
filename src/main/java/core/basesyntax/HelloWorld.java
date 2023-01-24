package core.basesyntax;

import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.SeparateServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final Map<Transaction.Operation, OperationHandler> operationHandlerMap = new
            HashMap<>();

    public static void main(String[] args) {

        operationHandlerMap.put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Transaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        List<String> stringsTransactions = new ReaderServiceImpl()
                .readData(INPUT_FILE);
        List<Transaction> transactionList = new SeparateServiceImpl()
                .parseTransactionList(stringsTransactions);
        for (Transaction transaction : transactionList) {
            OperationHandler handler = strategy.get(transaction.getOperation());
            handler.calculate(transaction);
        }
        new WriterServiceImpl().writeFile(REPORT_FILE);
    }
}
