package core.basesyntax.actions;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitTransaction;

public class BalanceAction implements DoingAction {

    @Override
    public void applyAction(FruitTransaction transaction, FruitDto fruit) {
        fruit.setQuantity(transaction.getQuantity());
    }
}
