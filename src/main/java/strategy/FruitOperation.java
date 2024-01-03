package strategy;

import model.FruitTransaction;

public interface FruitOperation {
    void execute(FruitTransaction fruitTransaction);
}
