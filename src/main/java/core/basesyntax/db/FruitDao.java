package core.basesyntax.db;

public interface FruitDao {
    void addOrUpdateFruitToStorage(String fruitName, Integer quantity);

    Integer getFruitQuantity(String fruitName);
}
