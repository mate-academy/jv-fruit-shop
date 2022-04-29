package strategy;

import model.Fruit;

public interface OperationHandler {
    public void operation(Fruit fruit, Integer quantity);
}
