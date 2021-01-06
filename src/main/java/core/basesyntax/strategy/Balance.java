package core.basesyntax.strategy;

import core.basesyntax.db.DataBase;
import core.basesyntax.model.Fruit;

public class Balance implements OperationStrategy {
    @Override
    public void apply(Fruit fruit, int amount) {
        DataBase.getListItems().put(fruit, amount);
    }
}
