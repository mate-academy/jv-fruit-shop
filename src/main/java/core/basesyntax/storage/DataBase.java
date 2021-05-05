package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<Fruit, Integer> dataBase = new HashMap<>();

    public DataBase(Map<Fruit, Integer> dataBase) {
        DataBase.dataBase = dataBase;
    }

    public static Map<Fruit, Integer> getDataBase() {
        return dataBase;
    }
}
