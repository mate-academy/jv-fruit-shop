package core.basesyntax.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseImpl implements DataBase {
    private static DataBase dataBase;
    private List<String[]> storageOfFruits;
    private Map<String, String> storageOfBalanceOfFruit;

    public DataBaseImpl() {
        this.storageOfFruits = new ArrayList<>();
        this.storageOfBalanceOfFruit = new HashMap<>();
    }

    public static DataBase getDataBase() {
        if (dataBase == null) {
            dataBase = new DataBaseImpl();
        }
        return dataBase;
    }

    public List<String[]> getStorageOfFruits() {
        return storageOfFruits;
    }

    public Map<String, String> getStorageOfBalanceOfFruit() {
        return storageOfBalanceOfFruit;
    }

    @Override
    public void addFruitToStorage(String[] arr) {
        storageOfFruits.add(arr);
    }

    @Override
    public void addBalanceOfFruit(String key, String val) {
        storageOfBalanceOfFruit.put(key, val);
    }

    @Override
    public List<String[]> getListOfFruitStorage() {
        return getStorageOfFruits();
    }

    @Override
    public Map<String, String> getMapOfBalanceStorage() {
        return getStorageOfBalanceOfFruit();
    }
}
