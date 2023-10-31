package core.basesyntax.dao;

public interface BalanceDao {
    void add(String fruitName, int amount);

    Integer get(String fruitName);
}
