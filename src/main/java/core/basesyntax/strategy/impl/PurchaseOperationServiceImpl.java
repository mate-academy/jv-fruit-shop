package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.exception.NotEnoughProductsException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class PurchaseOperationServiceImpl implements OperationService {
    private ProductDao productDao;

    public PurchaseOperationServiceImpl() {
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
