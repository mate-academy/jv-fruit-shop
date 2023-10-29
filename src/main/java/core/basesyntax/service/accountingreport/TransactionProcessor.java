package core.basesyntax.service.accountingreport;

import core.basesyntax.service.operation.FruitOperation;
import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitOperation> fruitTransactionList);
}
