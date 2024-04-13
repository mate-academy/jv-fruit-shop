package core.basesyntax.strategy;

public interface FruitHandler {
    int FRUIT_NAME_INDEX = 1;
    int FRUIT_QUANTITY_INDEX = 2;

    void transactionHandler(String[] transactionValues);
}
