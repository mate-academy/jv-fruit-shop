package service.activity;

import model.FruitTransaction;

public interface ActivityHandler {
    boolean handle(FruitTransaction fruitTransaction);
}
