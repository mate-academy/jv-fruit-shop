package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDaoService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class PlusOperationServiceImpl implements OperationService {
    private ProductDaoService productDaoService;

    public PlusOperationServiceImpl(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int total = productDaoService.getQuantityOf(fruitTransaction)
                + fruitTransaction.getQuantity();
        productDaoService.update(fruitTransaction, total);
    }
}
