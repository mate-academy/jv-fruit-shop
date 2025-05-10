package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.activities.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler getActivity(FruitTransaction.TypeOfActivity type);
}
