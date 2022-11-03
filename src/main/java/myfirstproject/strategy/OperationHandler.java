package myfirstproject.strategy;

import myfirstproject.model.Fruit;

public interface OperationHandler {
    void changeValue(Fruit fruit, int value);
}
