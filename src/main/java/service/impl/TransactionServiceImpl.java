package service.impl;

import db.Storage;
import java.util.List;
import models.Fruit;
import models.FruitTransaction;
import service.TransactionService;
import strategy.OperationStrategy;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void executeOperation(List<FruitTransaction> fruitTransactions) {
        int newFruitAmount;
        for (FruitTransaction transaction : fruitTransactions) {
            Fruit fruitFromTransaction = transaction.getFruit();
            int fruitIndex = Storage.fruitList.indexOf(fruitFromTransaction);
            if (fruitIndex >= 0) {
                newFruitAmount = operationStrategy.get(transaction.getOperation())
                        .calculateQuantity(Storage.fruitList.get(fruitIndex).getAmount(),
                                transaction.getQuantity());
                fruitFromTransaction.setAmount(newFruitAmount);
                Storage.fruitList.set(fruitIndex, fruitFromTransaction);
            } else {
                Storage.fruitList.add(fruitFromTransaction);
            }
        }
    }
}
