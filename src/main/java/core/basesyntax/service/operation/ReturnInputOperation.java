package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnInputOperation implements InputTransaction {
    private final FruitTransactionDao fruitTransactionDao;

    public ReturnInputOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void process(FruitTransaction fruitOperation) {
        Integer quantity = fruitTransactionDao.get(fruitOperation);
        if (quantity != null) {
            fruitOperation.setQuantity(quantity + fruitOperation.getQuantity());
            fruitTransactionDao.add(fruitOperation);
        }
    }
}
