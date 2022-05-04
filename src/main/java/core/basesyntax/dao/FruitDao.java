package core.basesyntax.dao;

public interface FruitDao {
    Integer get(String fruitName);
    void update(String fruitName, Integer amount);
}
