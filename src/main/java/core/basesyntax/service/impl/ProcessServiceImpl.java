package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public class ProcessServiceImpl implements ProcessService {
    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList,
                                    Map<OperationType, Operation> strategyMap) {
        fruitTransactionList.forEach(f -> strategyMap
                .get(f.getOperationType()).performOperation(f));
    }
}
