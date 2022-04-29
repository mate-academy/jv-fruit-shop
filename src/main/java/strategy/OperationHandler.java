package strategy;

import model.Fruit;

public interface OperationHandler {
    void apply(Fruit fruit, int quantity);
}
