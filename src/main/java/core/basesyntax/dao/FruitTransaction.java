package core.basesyntax.dao;

public interface FruitTransaction {
    Operation getOperation(String s);

    enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;
    }
}
