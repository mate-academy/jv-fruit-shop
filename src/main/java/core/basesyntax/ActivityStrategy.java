package core.basesyntax;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.activities.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler getActivity(Fruit.TypeOfActivity type);
}
