package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<String, Integer> dataBase = new HashMap<>();

    public DataBase(Map<String, Integer> dataBase) {
        DataBase.dataBase = dataBase;
    }

    public static Map<String, Integer> getDataBase() {
        return dataBase;
    }
}
