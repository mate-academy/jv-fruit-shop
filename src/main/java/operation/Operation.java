package operation;

import model.FruitTransaction;

public interface Operation {
    boolean proceed(FruitTransaction fruitTransaction);
}
