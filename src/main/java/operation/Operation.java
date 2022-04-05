package operation;

import model.FruitTransaction;

public interface Operation {
    Operation proceed(FruitTransaction fruitTransaction);
}
