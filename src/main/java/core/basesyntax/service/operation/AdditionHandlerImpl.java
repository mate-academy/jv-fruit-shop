package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class AdditionHandlerImpl implements Handler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantity = FruitStorage.fruitStorage.getOrDefault(transaction.getFruit(), 0)
                + transaction.getQuantity();
        FruitStorage.put(transaction.getFruit(), quantity);
    }
}
