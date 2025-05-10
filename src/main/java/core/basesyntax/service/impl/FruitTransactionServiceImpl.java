package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitShopDao fruitShopDao;
    private FruitStrategy fruitStrategy;

    public FruitTransactionServiceImpl(FruitShopDao fruitShopDao, FruitStrategy fruitStrategy) {
        this.fruitShopDao = fruitShopDao;
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            fruitStrategy.getOperationHandler(transaction.getOperation())
                    .handleOperation(transaction, fruitShopDao);
        }
        return fruitShopDao.getAllFruitsAndQuantities();
    }
}
