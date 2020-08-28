package core.basesyntax.fruitservice;

import java.util.List;

public class FruitStorageService {
    private static FruitStorage fruitStorage = new FruitStorage();

    public List<Transaction> getStorage() {
        return fruitStorage.getStorage();
    }

    public void addToStorage(Transaction transaction) {
        fruitStorage.getStorage().add(transaction);
    }

    public void addAllToStorage(List<Transaction> transactions) {
        fruitStorage.getStorage().addAll(transactions);
    }

    public void removeFromStorage(Transaction transaction) {
        fruitStorage.getStorage().remove(transaction);
    }
}
