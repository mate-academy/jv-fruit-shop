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
        for (FruitTransaction transaction : transactions) {
            fruitStrategy.getOperationHandler(transaction.getOperation())
                    .handleOperation(transaction);
        }
        return fruitShopDao.getAllFruitsAndQuantities().entrySet().stream().toList().toString();
    }
}
