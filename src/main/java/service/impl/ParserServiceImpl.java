package service.impl;

import model.Fruit;
import model.Transaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION = 0;
    private static final int PRODUCT = 1;
    private static final int QUANTITY = 2;
    private static final String SPLITTER = ",";

    @Override
    public Transaction parse(String line) {
        Transaction transaction = new Transaction();
        String[] splitData = line.split(SPLITTER);
        transaction.setOperation(splitData[OPERATION]);
        transaction.setFruit(new Fruit(splitData[PRODUCT]));
        transaction.setQuantity(Integer.parseInt(splitData[QUANTITY]));
        return transaction;
    }
}
