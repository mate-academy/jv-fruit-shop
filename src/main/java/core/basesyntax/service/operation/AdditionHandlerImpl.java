package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class AdditionHandlerImpl implements Handler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (FruitStorage.fruitStorage.get(transaction.getFruit()) == null) {
            FruitStorage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
        } else {
            int newQuantity = transaction.getQuantity()
                    + FruitStorage.fruitStorage.get(transaction.getFruit());
            FruitStorage.fruitStorage.put(transaction.getFruit(), newQuantity);
        }
    }
}
