package core.basesyntax.actions;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitTransaction;

public class ReturnAction implements DoingAction {
    @Override
    public void applyAction(FruitTransaction transaction, FruitDto fruit) {
        fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity());
    }
}
