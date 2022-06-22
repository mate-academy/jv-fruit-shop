package strategy;

import model.FruitTransaction;

public interface FruitHandler {
    void handleOperation(FruitTransaction transaction);
}
