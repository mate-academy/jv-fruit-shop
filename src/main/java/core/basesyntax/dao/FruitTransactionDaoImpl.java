package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(String fruit, int quantity) {
        DataBase.add(fruit, quantity);
    }

    @Override
    public void update(String fruit, int quantity) {
        DataBase.update(fruit, quantity);
    }

    public int getQuantity(String fruit) {
        return DataBase.get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return DataBase.getStorage();
    }
}
