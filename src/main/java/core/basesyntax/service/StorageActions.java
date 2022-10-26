package core.basesyntax.service;

public interface StorageActions {
    void removeFromStorage(String fruitType, int quantity);

    void addToStorage(String fruitType, int quantity);
}
