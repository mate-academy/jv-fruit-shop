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
        if (isNegative(transaction.getQuantity())) {
            throw new RuntimeException("Quantity can't be less than 0.");
        }
        int currentQuantity = fruitTransactionDao.getQuantity(transaction.getFruit());
        currentQuantity += transaction.getQuantity();
        fruitTransactionDao.update(transaction.getFruit(), currentQuantity);
    }

    private boolean isNegative(int num) {
        return num < 0;
    }
}
