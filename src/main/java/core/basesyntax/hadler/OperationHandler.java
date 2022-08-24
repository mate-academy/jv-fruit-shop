package core.basesyntax.hadler;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationHandler {
    int getAmount(String fruit, List<FruitTransaction> transactions);
}
