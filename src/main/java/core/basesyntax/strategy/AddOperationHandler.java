package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class AddOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public AddOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = fruitDao.getInteger(fruit);
        int quantity = transactionDto.getQuantity() + oldQuantity;
        fruitDao.add(fruit, quantity);
    }
}
