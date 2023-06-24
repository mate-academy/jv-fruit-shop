package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitTransactionService {
    void execute(List<FruitTransaction> transactions, 
            Map<Operation, OperationHandler> strategyMap);
}
