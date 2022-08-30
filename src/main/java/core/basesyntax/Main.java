package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FileParsedImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ReaderImpl().read("src/main/java/fruits");

        Map<Transaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
        map.put(Transaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());

        List<Transaction> transactions = new FileParsedImpl().parse(list);
        OperationStrategy operationStrategy = new OperationStrategy(map);
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().getReport();
        Writer writer = new WriterImpl();
        writer.write(report, "src/main/java/core/basesyntax/newFIle");
    }
}

