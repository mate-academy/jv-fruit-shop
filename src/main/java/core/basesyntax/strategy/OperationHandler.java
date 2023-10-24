package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationHandler {
    long count(List<FruitTransaction> fruits, String fruitName);
}
