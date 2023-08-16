package strategy;

import dao.FruitStorageDao;
import model.Fruit;

public interface OperationHandler {
    void handle(Fruit fruit, FruitStorageDao storage);
}
