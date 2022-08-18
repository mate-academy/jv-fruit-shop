package core.operations;

import core.model.FruitTransaction;

public interface Operation {
    void performOperation(FruitTransaction fruitTransaction);
}
