package core.basesyntax.service.impl.transactions;

import core.basesyntax.service.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {

    @Override
    public int getBalance(int storageBalance, int quantity) {
        int balance = storageBalance - quantity;
        if (balance >= 0) {
            return balance;
        }
        throw new RuntimeException("Quantity of purchase can't be bigger then balance in storage: "
                + "storage - "
                + balance + " purchase - "
                + quantity);
    }
}
