package strategy;

import model.FruitTransaction;

public interface ActivityHandler {
    void handle(FruitTransaction transaction);
}
