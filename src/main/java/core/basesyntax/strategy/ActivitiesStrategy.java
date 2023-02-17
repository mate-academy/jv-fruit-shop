package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface ActivitiesStrategy {
    void operation(List<FruitOperation> fruitOperations);
}
