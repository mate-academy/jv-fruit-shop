package core.basesyntax.strategy.impl;

import core.basesyntax.exception.NotEnoughProductsException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationService;

public class PurchaseOperationImpl implements OperationService {
    private ProductDao productDao;

    public PurchaseOperationImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int curAmount = productDao.getQuantityOf(fruitTransaction);
        if (curAmount < fruitTransaction.getQuantity()) {
            throw new NotEnoughProductsException("not enough product: "
                    + fruitTransaction.getFruit()
                    + ", in stock now: "
                    + curAmount
                    + ", but your order: " + fruitTransaction.getQuantity());
        }
        curAmount = curAmount - fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, curAmount);
    }
}
