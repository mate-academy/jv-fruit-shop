package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(final Map<Operation, OperationHandler> operations) {
        this.operationStrategy = new OperationStrategyImpl(operations);
    }

    @Override
    public String generateReport(final List<FruitTransaction> transactions) {
        addToStorage(transactions);
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        stringBuilder.append(System.lineSeparator());
        Storage.storage.forEach((key, value) -> stringBuilder
                .append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        return stringBuilder.toString();
    }

    private void addToStorage(final List<FruitTransaction> transactions) {
        transactions.forEach(e -> operationStrategy.get(e.getOperation()).handle(e));
    }
}
