package core.basesyntax.service.impl;

import core.basesyntax.Operation;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.FruitOperation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FruitTransactionImpl implements FruitTransaction {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_AMOUNT = 2;
    private final Map<Operation, FruitOperation> strategyMap;

    public FruitTransactionImpl(Map<Operation, FruitOperation> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public void process(List<String[]> lines) {
        for (String[] strings : lines) {
            Operation operation = Arrays.stream(Operation.values())
                    .filter(o -> o.getOperation().equals(strings[INDEX_OPERATION]))
                    .findFirst().get();
            String fruit = strings[INDEX_FRUIT];
            int quantity = Integer.parseInt(strings[INDEX_AMOUNT]);
            strategyMap.get(operation).apply(fruit, quantity);
        }
    }
}
