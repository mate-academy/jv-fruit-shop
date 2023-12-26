package strategy;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;

public interface FruitOperation {
    void execute(Storage storage, Map<String, Integer> fruitQuantities,
                 FruitTransaction fruitTransaction);
}
