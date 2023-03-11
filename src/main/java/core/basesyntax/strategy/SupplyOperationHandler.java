package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitDao;

    public SupplyOperationHandler(FruitStorageDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldValue = Storage.storage.get(fruit);
        if (fruitDao.contains(fruit)) {
            fruitDao.add(fruit, oldValue + transactionDto.getQuantity());
        } else {
            fruitDao.add(fruit, transactionDto.getQuantity());
        }
    }
}
