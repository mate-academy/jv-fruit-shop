package strategy.impl;

import model.FruitTransaction;
import strategy.GeneralOperation;
import strategy.TransactionHandler;

public class ReturnHandler implements GeneralOperation {
    private final TransactionHandler processTransaction;

    public ReturnHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void generalOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
