package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void calculate(FruitTransaction transaction);
}