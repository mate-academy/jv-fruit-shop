package service.impl;

import exception.FruitShopException;
import model.FruitTransaction;
import service.TransactionParserService;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public FruitTransaction parseFromString(String inputStrings) {
        String[] data = inputStrings.split(SEPARATOR);
        if (data.length != 3) {
            throw new FruitShopException("Can't parse data from file");
        }
        return new FruitTransaction(data[OPERATION], data[FRUIT], data[QUANTITY]);
    }
}
