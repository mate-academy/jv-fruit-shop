package strategy.impl;

import model.FruitTransaction;
import strategy.GeneralOperation;
import strategy.TransactionHandler;

public class PurchaseHandler implements GeneralOperation {
    private final TransactionHandler transactionHandler;

    public PurchaseHandler() {
        transactionHandler = new TransactionHandlerImpl();
    }

    @Override
    public void generalOperation(FruitTransaction transaction) {
        transactionHandler.takeFromBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
