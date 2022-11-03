package strategy.impl;

import model.FruitTransaction;
import strategy.GeneralOperation;
import strategy.TransactionHandler;

public class SupplyHandler implements GeneralOperation {
    private final TransactionHandler processTransaction;

    public SupplyHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void generalOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
