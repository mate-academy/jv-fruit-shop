package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.Performer;
import strategy.TransactionStrategy;
import strategy.operation.OperationHandler;

public class FruitOperationPerformer implements Performer<FruitTransaction> {
    private final TransactionStrategy transactionStrategy;

    public FruitOperationPerformer(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void performProcess(FruitTransaction transaction) {
        OperationHandler handler = transactionStrategy.get(transaction.getOperation());
        handler.doOperation(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public boolean performProcesses(List<FruitTransaction> transactions) {
        if (transactions == null) {
            return false;
        }
        if (transactions.size() == 0) {
            return false;
        }
        OperationHandler handler;
        for (FruitTransaction transaction : transactions) {
            handler = transactionStrategy.get(transaction.getOperation());
            handler.doOperation(transaction.getFruit(), transaction.getQuantity());
        }
        return true;
    }

}
