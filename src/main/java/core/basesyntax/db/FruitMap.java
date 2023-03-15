package core.basesyntax.db;

public interface FruitMap {
    void put(String fruit, int quantity);

    int get(String fruit);
}
