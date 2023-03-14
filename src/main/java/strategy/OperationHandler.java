package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void operateFruits(FruitTransaction transaction);
}
