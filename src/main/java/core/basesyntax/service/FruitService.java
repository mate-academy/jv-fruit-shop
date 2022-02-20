package core.basesyntax.service;

public interface FruitService {

    boolean balance(String fruitName, int quantity);

    boolean supplyFruit(String fruitName, int quantity);

    boolean purchaseFruit(String fruitName, int quantity);

    boolean returnFruit(String fruitName, int quantity);

    boolean createReport();

}
