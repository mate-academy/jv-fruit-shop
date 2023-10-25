package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationHandler {
    int count(FruitTransaction fruitTransaction);
}
