package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void calculate(Fruit fruit, FruitTransaction transaction) {
        fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity());
    }
}
