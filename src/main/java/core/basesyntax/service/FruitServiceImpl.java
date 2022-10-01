package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationStrategy> operations;

    public FruitServiceImpl(final Map<Operation, OperationStrategy> operations) {
        this.operations = operations;
    }

    @Override
    public String generateReport(final List<FruitTransaction> transactions) {
        return null;
    }
}
