package strategy.impl;

import model.FruitTransaction;
import strategy.GeneralOperation;
import strategy.TransactionHandler;

public class BalanceHandler implements GeneralOperation {
    private final TransactionHandler processTransaction;

    public BalanceHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void generalOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
