package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruitName, int amountOfFruit);

    int get(String fruit);
}
