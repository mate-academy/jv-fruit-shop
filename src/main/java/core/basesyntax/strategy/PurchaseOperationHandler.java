package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.OperationHandlerException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = fruitDao.getInteger(fruit);
        int sell = transactionDto.getQuantity();
        int newQuantity = oldQuantity - sell;
        if (newQuantity < 0) {
            throw new OperationHandlerException("Сan't sell more than you have. Capacity: "
                    + oldQuantity
                    + " Wanted to sell: " + sell);
        }
        fruitDao.add(fruit, newQuantity);
    }
}
