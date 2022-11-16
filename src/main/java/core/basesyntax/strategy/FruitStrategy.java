package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitTransaction.Operation;
import java.util.Map;

public class FruitStrategy implements IFruitStrategy {
    private final Map<String, Operation> listOperations;

    public FruitStrategy(Map<String, Operation> listOperations) {
        this.listOperations = listOperations;
    }

    @Override
    public FruitTransaction chooseOperation(String operation, String fruit, Integer quantity) {
        return new FruitTransaction(listOperations.get(operation), fruit, quantity);
    }
}
