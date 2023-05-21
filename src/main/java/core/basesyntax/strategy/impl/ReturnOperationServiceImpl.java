package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class ReturnOperationServiceImpl implements OperationService {
    private ProductDao productDaoService;

    public ReturnOperationServiceImpl(ProductDao productDaoService) {
        this.productDaoService = productDaoService;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int total = productDaoService.getQuantityOf(fruitTransaction)
                + fruitTransaction.getQuantity();
        if (total < 0) {
            throw new IllegalArgumentException("Balance can`t be negative, but was: " + total);
        }
        productDaoService.update(fruitTransaction, total);
    }
}
