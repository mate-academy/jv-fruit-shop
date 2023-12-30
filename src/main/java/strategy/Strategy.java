package strategy;

import model.FruitTransaction;

public interface Strategy {
    void processTransaction(FruitTransaction fruitTransaction);
}
