package core.basesyntax.service.strategy;

public interface TransactionHandler {
    public static final int FRUIT_INDEX = 1;
    public static final int FRUIT_QUANTITY = 2;

    void store(String[] oneTransaction);
}
