package core.service;

import core.service.handlers.FruitOperationHandler;

public interface UpdateFruitsStrategy {
    FruitOperationHandler get(String fruitOperation);
}
