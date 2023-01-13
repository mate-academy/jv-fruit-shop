package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int balance = FruitDao.getAll().get(transaction.getFruit());
        int fruitsToRemove = transaction.getQuantity();
        if (balance < fruitsToRemove) {
            throw new RuntimeException("Not enough fruits in storage.You have: " + balance);
        }
        FruitDao.getAll().put(transaction.getFruit(), balance - fruitsToRemove);
    }
}
