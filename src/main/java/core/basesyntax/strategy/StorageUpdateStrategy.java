package core.basesyntax.strategy;

public interface StorageUpdateStrategy {
    void updateStorage(String fruitName, int amount);

    boolean isServiceApplicable(String operationCode);
}
