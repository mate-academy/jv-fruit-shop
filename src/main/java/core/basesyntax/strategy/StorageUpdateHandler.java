package core.basesyntax.strategy;

public interface StorageUpdateHandler {
    void updateStorage(String fruitName, int amount);

    boolean isServiceApplicable(String operationCode);
}
