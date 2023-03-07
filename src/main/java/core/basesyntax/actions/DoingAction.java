package core.basesyntax.actions;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitTransaction;

public interface DoingAction {
    void applyAction(FruitTransaction transaction, FruitDto fruit);
}
