package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void getOperation(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationStrategy.get(transaction.getOperation())
                    .processTransaction(transaction.getFruit(), transaction.getQuantity());
        }
    }
}