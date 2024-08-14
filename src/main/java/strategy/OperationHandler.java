package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
