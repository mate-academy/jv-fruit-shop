package core.basesyntax.dao;

public interface FruitDao {
    void putFruitToStorage(String fruitName, Integer fruitQuantity);

    Integer getFruit(String fruitName);
}
