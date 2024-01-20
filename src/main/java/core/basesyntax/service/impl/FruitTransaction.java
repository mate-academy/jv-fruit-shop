package core.basesyntax.service.impl;

public interface FruitTransaction {

    void balance(String fruit, int quantity);

    void supply(String fruit, int quantity);

    void purchase(String fruit, int quantity);

    void returnFruits(String fruit, int quantity);
}
