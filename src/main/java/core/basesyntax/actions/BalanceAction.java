package core.basesyntax.actions;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceAction implements DoingAction {

    @Override
    public Fruit getCount(FruitTransaction transaction, Fruit fruit) {
        fruit.setQuantity(transaction.getQuantity());
        return fruit;
    }
}
