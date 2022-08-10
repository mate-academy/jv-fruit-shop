package core.basesyntax.service.data;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationService<T> {
    void processOperation(List<FruitTransaction> fruitTransactions);
}
