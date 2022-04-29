package service.impl;

import model.Product;
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
        String[] split = line.split(SPLITTER);
        transaction.setOperation(split[OPERATION]);
        transaction.setProduct(new Product(split[PRODUCT]));
        transaction.setQuantity(Integer.parseInt(split[QUANTITY]));
        return transaction;
    }
}
