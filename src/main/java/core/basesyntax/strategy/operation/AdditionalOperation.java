package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class AdditionalOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public AdditionalOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitDao.getAll()
                .merge(transaction.getFruit(),transaction.getQuantity(),Integer::sum);
    }
}
