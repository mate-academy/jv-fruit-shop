package core.basesyntax.strategy.actions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class ReturnActionHandler implements ActionHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() > Storage.getFruits().get(transaction.getFruit())) {
            throw new RuntimeException("Can't return more than there were in the first place");
        }
        Storage.plus(transaction.getFruit(), transaction.getQuantity());
    }
}
