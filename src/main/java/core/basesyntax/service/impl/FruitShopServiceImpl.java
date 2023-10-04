package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationsStrategy operationsStrategy;
    private FruitDao fruitDao;

    public FruitShopServiceImpl(OperationsStrategy operationsStrategy, FruitDao fruitDao) {
        this.operationsStrategy = operationsStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void calculateFruits(List<FruitTransaction> fruitTransaction) {
        fruitTransaction.forEach(fruitTransactionItem -> {
            Fruit fruit = new Fruit();
            fruit.setFruit(fruitTransactionItem.getFruit());
            fruit.setQuantity(operationsStrategy.get(fruitTransactionItem.getOperation())
                    .operate(fruitDao.get(fruitTransactionItem.getFruit()).getQuantity(),
                            fruitTransactionItem.getQuantity()));
            fruitDao.update(fruit);
        });
    }
}
