package core.basesyntax.strategy.impl;

import static core.basesyntax.model.FruitTransaction.Operation;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<Operation, OperationHandler> quantityHandlerMap;

    static {
        quantityHandlerMap = Arrays.stream(Operation.values())
                .collect(Collectors.toMap(Function.identity(), operation ->
                        operation == Operation.BALANCE
                                || operation == Operation.RETURN
                                || operation == Operation.SUPPLY
                                ? new PositiveOperationHandlerImpl() :
                                new NegativeOperationHandlerImpl()));
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Fruit operation cannot be null");
        }
        return quantityHandlerMap.get(operation);
    }
}
