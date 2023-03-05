package core.basesyntax.actions;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseAction implements DoingAction {
    @Override
    public Fruit getCount(FruitTransaction transaction, Fruit fruit) {
        fruit.setQuantity(fruit.getQuantity() - transaction.getQuantity());
        return fruit;
    }
}
