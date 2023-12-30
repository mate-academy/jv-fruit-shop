package strategy;

import dao.Storage;
import model.FruitTransaction;

public interface FruitOperation {
    void execute(Storage storage, FruitTransaction fruitTransaction);
}
