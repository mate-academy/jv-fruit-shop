package core.basesyntax.dao;

public interface FruitDao {
    void set(String product, int quantity);

    void add(String product, int quantity);

    void subtract(String product, int quantity);

    int get(String product);

    String[] getFruitsNames();
}
