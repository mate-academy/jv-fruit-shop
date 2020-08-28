package core.basesyntax.operations;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import java.time.LocalDate;

public class BuyOperation extends AbstactOperation implements StoreOperation {
    public BuyOperation(Storage storage) {
        super(storage);
    }

    @Override
    public void performOperation(Transaction transaction) {
        if (!checkFruitQuantity(transaction.getFruitName(), transaction.getQuantity())) {
            throw new IllegalArgumentException("We have less fruits than you want to buy");
        }
        if (!checkFreshFruitQuantity(transaction.getFruitName(),
                transaction.getQuantity(), transaction.getDate())) {
            throw new IllegalArgumentException("Not enough fresh fruits");
        }

        storage.removeFruits(transaction.getFruitName(), transaction.getQuantity());
    }

    private boolean checkFruitQuantity(String fruitName, int requiredQuantity) {
        long quantity = storage.getStorage().stream()
                .filter(f -> f.getFruitName().equals(fruitName))
                .count();
        return quantity >= requiredQuantity;
    }

    private boolean checkFreshFruitQuantity(String fruitName,
                                            int requiredQuantity, LocalDate date) {
        long quantity = storage.getStorage().stream()
                .filter(f -> f.getFruitName().equals(fruitName)
                        && f.getExpirationDate().isAfter(date))
                .count();
        return quantity >= requiredQuantity;
    }
}
