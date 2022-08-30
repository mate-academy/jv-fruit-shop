package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.impl.ParsedFileImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/file";
    private static final String OUTPUT_FILE_PATH = "src/main/java/core/basesyntax/report";

    public static void main(String[] args) {
        Map<Transaction.Operation, OperationHandler> map = new HashMap<>();
        putValues(map);
        OperationStrategy operationStrategy = new OperationStrategy(map);
        List<String> stringList = new ReaderImpl().read(INPUT_FILE_PATH);
        List<Transaction> transactions = new ParsedFileImpl().parsedList(stringList);
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().generateReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_PATH);

    }

    private static void putValues(Map<Transaction.Operation, OperationHandler> map) {
        map.put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
        map.put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());
        map.put(Transaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());
    }
}





