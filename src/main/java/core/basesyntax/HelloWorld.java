package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
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
        List<Transaction> transactionList = new TransactionParserImpl()
                .parseTransactionList(stringsTransactions);
        for (Transaction transaction : transactionList) {
            OperationHandler handler = strategy.get(transaction.getOperation());
            handler.calculate(transaction);
        }
        String report = new ReportGeneratorImpl().generateReport();
        new WriterServiceImpl().writeFile(REPORT_FILE, report);
    }
}
