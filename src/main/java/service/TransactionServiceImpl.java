package service;

import database.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operation.OperationStrategy;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> countsFruitsAfterWorkDay(List<FruitTransaction>
                                                                     fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .applyNewAmount(fruitTransaction.getFruitName(),
                            fruitTransaction.getQuantity());
        }
        return new HashMap<>(Storage.fruitTransactionStorage);
    }
}
