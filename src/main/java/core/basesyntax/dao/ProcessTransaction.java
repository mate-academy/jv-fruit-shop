package core.basesyntax.dao;

public interface ProcessTransaction {
    void addToBalance(String fruit, Integer quantity);

    void takeFromBalance(String fruit, Integer quantity);
}
