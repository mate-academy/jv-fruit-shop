package strategy;

import model.FruitTransaction;

public interface OperationHandler {

    void doOperation(FruitTransaction transaction);
}
