package service;

import dao.StorageDaoImpl;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TYPE_OF_TRANSACTION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String NEGATIVE_TRANSACTION = "p";
    private static final String DELIMITER = ",";
    StorageDaoImpl dao = new StorageDaoImpl();

    @Override
    public FruitTransaction createFruitTransaction(String stringFromFile) {
        return new FruitTransaction(getTypeTransactionFromString(stringFromFile),
                getTypeOfFruitFromString(stringFromFile),
                getAmountFromString(stringFromFile));
    }

    @Override
    public FruitTransaction createFruitTransaction(String type, String fruit, int quantity) {
        if (type.equals(NEGATIVE_TRANSACTION) && quantity > 0) {
            quantity *= -1;
        }
        return new FruitTransaction(type, fruit, quantity);
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        dao.addTransaction(transaction);
    }

    private String getTypeTransactionFromString(String string) {
        return string.split(DELIMITER)[TYPE_OF_TRANSACTION];
    }

    private String getTypeOfFruitFromString(String string) {
        return string.split(DELIMITER)[TYPE_OF_FRUIT];
    }

    private int getAmountFromString(String string) {
        int amount = Integer.parseInt(string.split(DELIMITER)[AMOUNT]);
        if (getTypeTransactionFromString(string).equals(NEGATIVE_TRANSACTION) && amount > 0) {
            return amount * -1;
        }
        return amount;
    }

}
