package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategySupplier;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OperationStrategySupplierImpl implements OperationStrategySupplier {
    private final Map<FruitTransaction.Operation, OperationStrategy> strategies;

    public OperationStrategySupplierImpl(Map<FruitTransaction.Operation,
            OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationStrategy get(FruitTransaction.Operation operation) {
        return Optional.ofNullable(strategies.get(operation))
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "There is no such operation: " + operation.name()));
    }
}
