package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionHandler {
    public void parse(List<FruitTransaction> fruitTransactionList,
                      OperationStrategy operationStrategy);
}
