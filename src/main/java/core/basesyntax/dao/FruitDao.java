package core.basesyntax.dao;

public interface FruitDao {
    void addFruits(String fruitName, Integer fruitAmount);

    Integer get(String fruit);
}
