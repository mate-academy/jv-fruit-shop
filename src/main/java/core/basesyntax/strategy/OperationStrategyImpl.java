package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    private FruitStorageDao fruitStorageDao;

    @Override
    public void apply(FruitTransaction fruitTransaction) {

        if (fruitTransaction.getOperation() == Operation.BALANCE) {
            fruitStorageDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        if (fruitTransaction.getOperation() == Operation.PURCHASE) {
            fruitStorageDao.remove(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        if (fruitTransaction.getOperation() == Operation.RETURN) {
            fruitStorageDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        if (fruitTransaction.getOperation() == Operation.SUPPLY) {
            fruitStorageDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
