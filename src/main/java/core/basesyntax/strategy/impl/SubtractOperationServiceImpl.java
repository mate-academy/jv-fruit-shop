package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDaoService;
import core.basesyntax.exception.NotEnoughProductsExeption;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class SubtractOperationServiceImpl implements OperationService {
    private ProductDaoService productDaoService;

    public SubtractOperationServiceImpl(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int curAmount = productDaoService.getQuantityOf(fruitTransaction);
        if (curAmount >= fruitTransaction.getQuantity()) {
            curAmount = curAmount - fruitTransaction.getQuantity();
            productDaoService.update(fruitTransaction, curAmount);
            return;
        }
        throw new NotEnoughProductsExeption("not enough product: "
                + fruitTransaction.getFruit()
                + ", in stock now: "
                + curAmount
                + ", but your order: " + fruitTransaction.getQuantity());
    }
}
