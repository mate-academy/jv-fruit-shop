package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SubtractionOperation implements OperationType {
    private final FruitDao fruitDao;

    public SubtractionOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void revisionOperation(FruitTransaction transaction) {
        fruitDao.getAll()
                .merge(transaction.getFruit(), transaction.getQuantity(),
                        (oldQuantity, newQuantity) -> oldQuantity - newQuantity);
    }
}
