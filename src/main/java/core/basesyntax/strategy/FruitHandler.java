package core.basesyntax.strategy;

public interface FruitHandler {
    int INDEX_FRUIT = 1;
    int INDEX_AMOUNT = 2;

    void handle(String[] line);
}
