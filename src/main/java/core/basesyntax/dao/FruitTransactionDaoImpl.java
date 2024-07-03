package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import java.util.Map;
import java.util.Set;

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
    public Set<Map.Entry<String, Integer>> getEntries() {
        return DataBase.entries();
    }
}
