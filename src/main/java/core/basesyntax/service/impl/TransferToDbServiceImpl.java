package core.basesyntax.service.impl;

import core.basesyntax.service.TransferToDbService;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransferToDbServiceImpl implements TransferToDbService {
    private final OperationStrategy operationStrategy;

    public TransferToDbServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operationStrategy.get(t.getOperation()).operate(t));
    }
}
