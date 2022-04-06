package strategy;

import model.FruitTransaction;

public interface FruitStrategy {
    void proceed(FruitTransaction fruitTransaction);
}
