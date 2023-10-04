package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    private static final String SEPARATOR = ",";

    @Override
    public String getAllData() {
        String result = new String();
        for (Map.Entry<String, Integer> fruit : Storage.listFruits.entrySet()) {
            result += fruit.getKey() + SEPARATOR + fruit.getValue() + System.lineSeparator();
        }
        return result;
    }
}
