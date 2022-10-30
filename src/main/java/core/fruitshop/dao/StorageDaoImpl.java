package core.fruitshop.dao;

import core.fruitshop.db.Storage;
import core.fruitshop.exceptions.NoSuchProductException;
import core.fruitshop.exceptions.ProductAmountException;

public class StorageDaoImpl implements StorageDao {
    private static final String AMOUNT_LESS_THEN_ZERO_EXCEPTION
            = "Amount can't be less then zero for product ";
    private static final String AMOUNT_TO_MINUS_INCORRECT_EXCEPTION = "Amount to minus can't be " +
            "greater then current amount: ";
    private static final String NOT_EXISTS_EXCEPTION = " doesn't exist in storage";

    @Override
    public void addProduct(String productName, int amount) {
        if (amount < 0) {
            throw new ProductAmountException(AMOUNT_LESS_THEN_ZERO_EXCEPTION + productName);
        }
        if (!contains(productName)) {
            Storage.fruitsStorage.put(productName, amount);
        }
    }

    @Override
    public void minusAmount(String productName, int amount) {
        if (amount < 0) {
            throw new ProductAmountException(AMOUNT_LESS_THEN_ZERO_EXCEPTION + productName);
        }
        int currentAmount = getAmount(productName);
        if (currentAmount < amount) {
            throw new ProductAmountException(AMOUNT_TO_MINUS_INCORRECT_EXCEPTION + currentAmount);
        }
        Storage.fruitsStorage.put(productName, currentAmount - amount);
    }

    @Override
    public void addAmount(String productName, int amount) {
        if (amount < 0) {
            throw new ProductAmountException(AMOUNT_LESS_THEN_ZERO_EXCEPTION + productName);
        }
        int currentAmount = getAmount(productName);
        Storage.fruitsStorage.put(productName, currentAmount + amount);
    }

    private int getAmount(String productName) {
        if (!contains(productName)) {
            throw new NoSuchProductException(productName + NOT_EXISTS_EXCEPTION);
        }
        return Storage.fruitsStorage.get(productName);
    }

    private boolean contains(String productName) {
        return Storage.fruitsStorage.containsKey(productName);
    }
}
