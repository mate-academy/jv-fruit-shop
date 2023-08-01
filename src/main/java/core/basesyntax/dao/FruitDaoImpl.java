package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final OperationStrategy operationStrategy;

    public FruitDaoImpl(OperationStrategy operationStrategy) {
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
