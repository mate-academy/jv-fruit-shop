package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitDao;

    public BalanceOperationHandler(FruitStorageDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        fruitDao.add(fruit, transactionDto.getQuantity());
    }
}
