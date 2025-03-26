package strategy;

import db.StorageService;

public class PurchaseImpl implements Operation {
    private static final String ERROR = "Cannot purchase more fruits than available for fruit: ";

    @Override
    public void execute(StorageService storage, String fruit, int quantity) {
        int currentQuantity = storage.get(fruit);
        int newQuantity = currentQuantity - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException(ERROR + fruit);
        }
        storage.put(fruit, newQuantity);
    }
}
