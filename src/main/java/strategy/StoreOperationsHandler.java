package strategy;

import model.FruitTransaction;

public interface StoreOperationsHandler {
    void useOperation(FruitTransaction transaction);
}
