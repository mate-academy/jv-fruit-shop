package strategy.impl;

import model.FruitTransaction;
import strategy.GeneralOperation;
import strategy.TransactionHandler;

public class PurchaseHandler implements GeneralOperation {
    private final TransactionHandler processTransaction;

    public PurchaseHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void generalOperation(FruitTransaction transaction) {
        processTransaction.takeFromBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
