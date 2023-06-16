package core.basesyntax.service;

public interface FruitInventoryManipulator {
    Integer getValue(String fruit);

    void add(String fruit, int quantity);

    void subtract(String fruit, int quantity);

    void validateValue(Integer value);
}
