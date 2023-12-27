package strategy;

import db.Storage;
import model.FruitTransaction;

public interface FruitOperation {
    void execute(Storage storage, FruitTransaction fruitTransaction);
}
