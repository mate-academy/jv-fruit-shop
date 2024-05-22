package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    public void add(String fruit, int quantity);

    public void change(String fruit, int newQuantity);

    public int get(String fruit);

    public Map<String, Integer> getAll();
}
