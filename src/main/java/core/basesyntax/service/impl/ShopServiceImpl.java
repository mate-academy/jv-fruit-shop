package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final FruitDao fruitDao;

    public ShopServiceImpl(OperationStrategy operationStrategy, FruitDao fruitDao) {
        this.operationStrategy = operationStrategy;
        this.fruitDao = fruitDao;
    }

    public Map<String, Integer> getFruitMap() {
        return fruitDao.getAllFruits();
    }

    @Override
    public void proceedAll(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new RuntimeException("Transaction is null: "
                        + Arrays.toString(transactions.toArray()));
            }
            operationStrategy
                    .choseOperationHandler(transaction.getOperation())
                    .executeOperation(fruitDao, transaction);
        }
    }
}
