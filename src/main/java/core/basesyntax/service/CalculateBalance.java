package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface CalculateBalance {
    void calculateBalance(List<FruitTransaction> fruitTransaction,
                          Map<FruitTransaction.Operation, OperationHandler> correspondenceTable);
}
