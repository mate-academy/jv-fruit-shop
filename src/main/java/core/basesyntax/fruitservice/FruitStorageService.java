package core.basesyntax.fruitservice;

public class FruitStorageService {
    public void addToStorage(Transaction transaction) {
        FruitStorage.getStorage().add(transaction);
    }

    public void removeFromStorage(Transaction transaction) {
        FruitStorage.getStorage().remove(transaction);
    }
}
