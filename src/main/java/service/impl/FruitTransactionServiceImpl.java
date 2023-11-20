package service.impl;

import db.FruitShopDao;
import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionService;
import strategy.FruitStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitShopDao fruitShopDao;
    private FruitStrategy fruitStrategy;

    public FruitTransactionServiceImpl(FruitShopDao fruitShopDao, FruitStrategy fruitStrategy) {
        this.fruitShopDao = fruitShopDao;
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public String processTransactions(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Incorrect data passed!");
        }
        for (FruitTransaction transaction : transactions) {
            processSingleTransaction(transaction);
        }
        return fruitShopDao.getAllFruitsAndQuantities().entrySet().stream().toList().toString();
    }

    private void processSingleTransaction(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int newQuantity = fruitStrategy.getOperationHandler(fruitTransaction.getOperation())
                .handleOperation(fruitName, quantity);
        fruitShopDao.put(fruitName, newQuantity);
    }
}
