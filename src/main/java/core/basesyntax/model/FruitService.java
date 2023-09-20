package core.basesyntax.model;

import core.basesyntax.handler.TransactionHandler;
import java.util.List;
import java.util.Map;

public class FruitService {
    private final Map<Transaction, TransactionHandler> handlerMap;

    public FruitService(Map<Transaction, TransactionHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public void manageTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> handlerMap.get(t.getTransaction()).apply(t));
    }
}
