package core.basesyntax.service;

public interface FruitService {
    void update(String fruitName, Integer amount);

    Integer getQuantity(String fruitName);
}
