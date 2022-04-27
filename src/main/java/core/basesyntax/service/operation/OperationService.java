package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationService {
    void process(List<FruitTransaction> fruitTransactionList);
}
