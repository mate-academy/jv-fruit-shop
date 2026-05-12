package core.basesyntax.transaction;

import static core.basesyntax.transaction.Validator.validate;

import core.basesyntax.db.Storage;

public class ShopTransaction implements Transaction {
    private static final String ERR_UPDATE_FAILED_FORMAT
            = "Failed to update item '%s' with value %d";
    private static final String ERR_CREATE_FAILED_FORMAT
            = "Failed to create item '%s' with value %d";
    private final Storage storage;

    public ShopTransaction(Storage storage) {
        this.storage = storage;
    }

    private int change(String item, Integer delta) {
        Integer lastValue = storage.read(item);
        if (lastValue == null) {
            throw new IllegalArgumentException("Item '" + item + "' not found in storage!");
        }
        int newValue = lastValue + delta;
        if (newValue < 0 || !storage.update(item, newValue)) {
            throw new IllegalStateException(
                    String.format(ERR_UPDATE_FAILED_FORMAT, item, newValue)
            );
        }
        return newValue;
    }

    @Override
    public Integer init(String item, Integer quantity) {
        validate(item, quantity);
        if (storage.create(item, quantity)) {
            return quantity;
        }
        throw new IllegalStateException(
                String.format(ERR_CREATE_FAILED_FORMAT, item, quantity));
    }

    @Override
    public Integer get(String item) {
        return storage.read(item);
    }

    @Override
    public Integer add(String item, Integer quantity) {
        validate(item, quantity);
        return change(item, quantity);
    }

    @Override
    public Integer subtract(String item, Integer quantity) {
        validate(item, quantity);
        return change(item, -1 * quantity);
    }

}
