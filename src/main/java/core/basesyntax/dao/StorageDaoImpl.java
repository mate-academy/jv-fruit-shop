package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

import java.util.stream.Collectors;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addToStorage(Transaction transaction) {
        Storage.fruitStorage.put(transaction.getFruitName(), transaction.getQuantity());
    }

    @Override
    public void removeFromStorage(Transaction transaction) {
        Integer currentQuantity = Storage.fruitStorage.get(transaction.getFruitName());
        int difference = currentQuantity - transaction.getQuantity();
        if (difference < 0) {
            throw new RuntimeException(transaction.getFruitName() + " not enough at the storage");
        }
        Storage.fruitStorage.put(transaction.getFruitName(), difference);
    }

    @Override
    public void updateStorage(Transaction transaction) {
        if (!Storage.fruitStorage.containsKey(transaction.getFruitName())) {
            Storage.fruitStorage.put(transaction.getFruitName(), transaction.getQuantity());
        }
        Integer currentQuantity = Storage.fruitStorage.get(transaction.getFruitName());
        Storage.fruitStorage.put(transaction.getFruitName(), transaction.getQuantity() + currentQuantity);
    }

    @Override
    public String getInformation() {
        return Storage.fruitStorage.entrySet().stream()
                .map(e -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(e.getKey()).append(",").append(e.getValue());
                    return builder.toString();
                }).collect(Collectors.joining(System.lineSeparator()));
    }


}
