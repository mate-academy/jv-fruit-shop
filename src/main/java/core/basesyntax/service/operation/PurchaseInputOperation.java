package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseInputOperation implements InputTransaction {
    private final FruitTransactionDao fruitTransactionDao;

    public PurchaseInputOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void process(FruitTransaction fruitOperation) {
        Integer quantity = fruitTransactionDao.get(fruitOperation);
        if (quantity != null && quantity >= fruitOperation.getQuantity()) {
            int newQuantity = quantity - fruitOperation.getQuantity();
            fruitOperation.setQuantity(newQuantity);
            fruitTransactionDao.add(fruitOperation);
        }
    }
}
