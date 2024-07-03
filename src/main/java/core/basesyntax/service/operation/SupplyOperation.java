package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public SupplyOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }
    @Override
    public void recount(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be less than 0.");
        }
        int currentQuantity = fruitTransactionDao.get(transaction.getFruit());
        currentQuantity += transaction.getQuantity();
        fruitTransactionDao.update(transaction.getFruit(), currentQuantity);
    }
}
