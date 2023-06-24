package core.basesyntax.strategy.actions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseActionHandler implements ActionHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Integer initialAmount = Storage.getFruits().get(transaction.getFruit());
        if (initialAmount == null) {
            throw new RuntimeException("Can't purchase not existent fruit");
        }
        if (transaction.getQuantity() > initialAmount) {
            throw new RuntimeException("Can't remove more than there is in stock");
        }
        Storage.minus(transaction.getFruit(), transaction.getQuantity());
    }
}
