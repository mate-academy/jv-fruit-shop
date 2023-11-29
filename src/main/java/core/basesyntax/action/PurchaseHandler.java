package core.basesyntax.action;

import core.basesyntax.model.Fruit;

public class PurchaseHandler implements ActionHandler {
    @Override
    public int performAction(Fruit fruit, int amount) {
        return fruit.getAmount() - amount;
    }
}
