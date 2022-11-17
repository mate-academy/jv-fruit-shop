package core.basesyntax.strategy;

import core.basesyntax.service.operations.IOperation;
import java.util.Map;

public class FruitStrategy implements IFruitStrategy {
    private final Map<String, IOperation> listOperations;

    public FruitStrategy(Map<String, IOperation> listOperations) {
        this.listOperations = listOperations;
    }

    @Override
    public void chooseOperation(String operation, String fruit, Integer quantity) {
        listOperations.get(operation).makeOperation(fruit, quantity);
    }
}
