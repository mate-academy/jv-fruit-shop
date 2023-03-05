package core.basesyntax.actions;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface DoingAction {
    Fruit getCount(FruitTransaction transaction, Fruit fruit);
}
