package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruitName, int quantity);

    int get(String fruitName);

    void update(String fruitName, int quantity);

    boolean containsFruit(String fruitName);
}
