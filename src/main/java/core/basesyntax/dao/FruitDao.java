package core.basesyntax.dao;

public interface FruitDao {
    Integer getQuantity(String fruitName);

    void update(String fruitName, Integer amount);
}
