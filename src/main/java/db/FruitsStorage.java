package db;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//DB for fruits
public class FruitsStorage {
    private final Map<String, Integer> fruitsStorage;

    public FruitsStorage() {
        this.fruitsStorage = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getFruitsStorage() {
        return fruitsStorage;
    }

    public void addFruitsStorage(String name, Integer value) {
        this.fruitsStorage.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitsStorage that = (FruitsStorage) o;
        return Objects.equals(fruitsStorage, that.fruitsStorage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitsStorage);
    }

    @Override
    public String toString() {
        return "FruitsStorage{" + "fruitsStorage=" + fruitsStorage + '}';
    }
}
