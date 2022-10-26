package core.basesyntax.service;

public interface StorageActionsService {
    void removeFromStorage(String fruitType, int quantity);

    void addToStorage(String fruitType, int quantity);
}
