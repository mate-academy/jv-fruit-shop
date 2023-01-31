package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.reader.Reader;
import core.basesyntax.reader.ReaderImpl;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.transaction.PurchaseTransaction;
import core.basesyntax.transaction.SetBalanceTransaction;
import core.basesyntax.transaction.SupplyFruitTransaction;
import core.basesyntax.transaction.TransactionHandler;
import core.basesyntax.writer.Writer;
import core.basesyntax.writer.WriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/resources/input.csv";
        Map<String, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put("b", new SetBalanceTransaction());
        transactionHandlerMap.put("s", new SupplyFruitTransaction());
        transactionHandlerMap.put("r", new SupplyFruitTransaction());
        transactionHandlerMap.put("p", new PurchaseTransaction());

        Reader reader = new ReaderImpl();
        List<Transaction> transactionList = reader.read(filePath);
        Storage storage = new StorageImpl();
        TransactionService transactionService = new TransactionServiceImpl(storage);
        TransactionStrategy transactionStrategy
                = new TransactionStrategyImpl(transactionHandlerMap);

        for (Transaction transaction : transactionList) {
            transactionService.handleTransaction(
                    transactionStrategy.getHandler(transaction.getType()),
                    transaction.getFruitName(),
                    transaction.getAmount()
            );
        }

        String reportFilePath = "src/resources/report.csv";
        Writer writer = new WriterImpl(reportFilePath);
        writer.write(storage.getAll());
    }
}
