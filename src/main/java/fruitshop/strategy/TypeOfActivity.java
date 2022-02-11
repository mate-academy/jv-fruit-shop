package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public interface TypeOfActivity {
    void realizeType(FruitTransaction fruitTransaction);
}
