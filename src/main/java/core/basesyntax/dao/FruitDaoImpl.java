package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
// переробити, щоб брався один елемент або додавався один елемент із списку
    @Override
    public void add(String fruitName, Integer fruitQuantity) {
        Storage.fruits.put(fruitName, fruitQuantity);
    }

    @Override
    public Map<String, Integer> getFromStorage() {
        return Storage.fruits;
    }
}
