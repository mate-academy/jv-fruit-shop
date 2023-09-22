package core.basesyntax.impl;

import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public class FruitService {
    private final Map<Operation, TransactionHandler> handlerMap;

    public FruitService(Map<Operation, TransactionHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public void manageTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> handlerMap.get(t.getTransaction()).apply(t));
    }
}
