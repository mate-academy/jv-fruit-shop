package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.InsertDataToBase;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class InsertDataToBaseImpl implements InsertDataToBase {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public InsertDataToBaseImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void addTransferToStorage(List<Transaction> transactions) {
        for (int i = 1; i < transactions.size(); i++) {
            if (!Storage.fruits.containsKey(transactions.get(i).getFruit())) {
                Storage.fruits.put(transactions.get(i).getFruit(),
                        transactions.get(i).getQuantity());
            } else {
                Storage.fruits.put(transactions.get(i).getFruit(),
                        operationHandlerStrategy.get(transactions.get(i).getOperation())
                        .apply(Storage.fruits.get(transactions.get(i).getFruit()),
                                transactions.get(i).getQuantity()));
            }
        }
    }
}
