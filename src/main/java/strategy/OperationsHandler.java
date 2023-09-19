package strategy;

import model.FruitTransaction;

public interface OperationsHandler {
    void useOperation(FruitTransaction transaction);
}
