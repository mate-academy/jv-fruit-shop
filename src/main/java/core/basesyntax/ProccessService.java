package core.basesyntax;

import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;

public class ProccessService {
    private final Map<Transaction, TransactionHandler> processedStoreHanler;

    public ProccessService(Map<Transaction, TransactionHandler> processedStoreHanler) {
        this.processedStoreHanler = processedStoreHanler;
    }

    public void proccessing(List<FruitTransaction> fruitTransactionsList) {
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            processedStoreHanler.get(fruitTransaction.getTransaction()).apply(fruitTransaction);
        }
    }
}
