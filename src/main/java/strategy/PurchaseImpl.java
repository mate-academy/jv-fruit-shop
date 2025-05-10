package strategy;

import db.Storage;

public class PurchaseImpl implements Operation {
    private static final String ERROR = "Cannot purchase more fruits than available for fruit: ";
    private static final String AVAILABLE = ". Available: ";
    private static final String QUANTITY_NOT_NEGATIVE = "Purchase quantity cannot be negative: ";
    private static final int ZERO = 0;

    @Override
    public void execute(String fruit, int quantity) {
        if (quantity < ZERO) {
            throw new IllegalArgumentException(QUANTITY_NOT_NEGATIVE + quantity);
        }
        int currentQuantity = Storage.storage.getOrDefault(fruit, ZERO);
        int newQuantity = currentQuantity - quantity;
        if (newQuantity < ZERO) {
            throw new RuntimeException(ERROR + fruit + AVAILABLE + fruit);
        }
        Storage.storage.put(fruit, newQuantity);
    }
}
