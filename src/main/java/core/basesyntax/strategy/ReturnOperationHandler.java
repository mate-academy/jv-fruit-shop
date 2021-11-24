package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitDao;

    public ReturnOperationHandler(FruitStorageDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int newQuantity = Storage.storage.get(fruit) + transactionDto.getQuantity();
        fruitDao.add(fruit, newQuantity);
    }
}
