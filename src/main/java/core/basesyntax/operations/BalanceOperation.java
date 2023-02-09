package core.basesyntax.operations;

import static core.basesyntax.db.Storage.fruitStorage;

public class BalanceOperation implements Operational {
    @Override
    public void action(String fruit, int amount) {
        fruitStorage.put(fruit, amount);
    }
}
