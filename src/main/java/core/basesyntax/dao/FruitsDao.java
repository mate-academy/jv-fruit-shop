package core.basesyntax.dao;

public interface FruitsDao {
    void add(String fruitType, int quantityOfFruit);

    int getQuantityOfFruit(String fruitType);

    boolean containsFruit(String fruitType);

}
