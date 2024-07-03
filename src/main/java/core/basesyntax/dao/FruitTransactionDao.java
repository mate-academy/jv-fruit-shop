package core.basesyntax.dao;

public interface FruitTransactionDao {
    void add(String fruit, int quantity);
    void update(String fruit, int quantity);
    int get (String fruit);
}
