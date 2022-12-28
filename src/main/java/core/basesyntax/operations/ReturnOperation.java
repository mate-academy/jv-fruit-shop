package core.basesyntax.operations;

import static core.basesyntax.db.Storage.fruitStorage;

public class ReturnOperation implements Operational {
    @Override
    public void action(String fruit, int amount) {
        fruitStorage.put(fruit, fruitStorage.get(fruit) + amount);
    }
}
