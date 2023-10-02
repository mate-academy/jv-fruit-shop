package core.basesyntax.db;

public interface FruitDao {
    void increment(String fruit, int count);

    void decrement(String fruit, int count);

    int getCount(String fruit);

    String[] getAllFruits();
}
