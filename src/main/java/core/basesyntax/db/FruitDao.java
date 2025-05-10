package core.basesyntax.db;

public interface FruitDao {

    void saveOrUpdate(String fruitName, Integer quantity);

    Integer getFruitQuantity(String fruitName);
}
