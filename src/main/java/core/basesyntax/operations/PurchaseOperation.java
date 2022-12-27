package core.basesyntax.operations;

import static core.basesyntax.db.Storage.fruitStorage;

public class PurchaseOperation implements Operation {
    @Override
    public void action(String fruit, int amount) {
        fruitStorage.put(fruit, fruitStorage.get(fruit) - amount);
    }
}
