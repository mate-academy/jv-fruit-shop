package operation;

import model.Fruit;

public interface OperationHandler {
    void apply(Fruit fruit, int quantity);
}
