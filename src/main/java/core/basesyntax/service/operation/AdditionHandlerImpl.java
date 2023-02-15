package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class AdditionHandlerImpl implements Handler {
    @Override
    public void handle(FruitTransaction transaction) {
        FruitStorage.put(transaction.getFruit(), calculateQuantity(transaction));
    }

    public static int calculateQuantity(FruitTransaction transaction) {
        int quantity = 0;
        if (FruitStorage.fruitStorage.get(transaction.getFruit()) == null) {
            quantity = transaction.getQuantity();
        } else {
            quantity = transaction.getQuantity()
                    + FruitStorage.fruitStorage.get(transaction.getFruit());
        }
        return quantity;
    }
}
