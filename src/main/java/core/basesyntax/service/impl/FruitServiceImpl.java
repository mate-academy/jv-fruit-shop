package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void add(FruitTransaction transaction) {
        operationStrategy.getOperation(transaction.getOperation())
                .executeOperation(transaction);
    }

    @Override
    public void addAll(List<FruitTransaction> transactions) {
        transactions.forEach(this::add);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.STORAGE;
    }
}
