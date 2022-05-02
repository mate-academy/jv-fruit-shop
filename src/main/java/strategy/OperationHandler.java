package strategy;

import model.Fruit;

public interface OperationHandler {
    public void process(Fruit fruit, Integer quantity);
}
