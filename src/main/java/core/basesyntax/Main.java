package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Main {
    public static void main(String[] args) {
        // Add some fruit transactions to the storage
        Storage.storage.put("apple", 10);
        Storage.storage.put("banana", 15);
        FruitTransaction applePurchase = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "apple", 10);
        FruitTransaction bananaPurchase = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "banana", 15);
        processTransaction(applePurchase);
        processTransaction(bananaPurchase);
        System.out.println("Updated Storage:");
        Storage.storage.forEach((fruit, quantity) -> {
            System.out.println(fruit + ": " + quantity);
        });
    }

    private static void processTransaction(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
            Storage.storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
        }
    }
}
