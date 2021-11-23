package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void action(Fruit fruit, int quantity);

    default void isPositiveQuantity(int quantity){
        if(quantity < 0){
            throw new RuntimeException("For some action quantity must be positive num");
        }
    }
}
