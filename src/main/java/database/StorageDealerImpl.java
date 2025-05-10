package database;

public class StorageDealerImpl implements StorageDealer {
    @Override
    public void updateDatabase(String fruit, int quantity) {
        ensureNonNegativeBalance(fruit, quantity);
        Storage.updateStorage(fruit, quantity);
    }

    private void ensureNonNegativeBalance(String fruit, int quantity) {
        if (Storage.getAssortment().containsKey(fruit)) {
            int currentBalanceForThisFruit = Storage.getAssortment().get(fruit);
            if (currentBalanceForThisFruit + quantity < 0) {
                throw new RuntimeException("Negative balance for fruit: " + fruit
                        + " with quantity: " + quantity);
            }
        }
    }
}


