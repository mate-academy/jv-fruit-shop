package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.exception.NotEnoughProductsExeption;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class PurchaseOperationServiceImpl implements OperationService {
    private ProductDao productDaoService;

    public PurchaseOperationServiceImpl(ProductDao productDaoService) {
        this.productDaoService = productDaoService;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int curAmount = productDaoService.getQuantityOf(fruitTransaction);
        if (curAmount < fruitTransaction.getQuantity()) {
            throw new NotEnoughProductsExeption("not enough product: "
                    + fruitTransaction.getFruit()
                    + ", in stock now: "
                    + curAmount
                    + ", but your order: " + fruitTransaction.getQuantity());
        }
        curAmount = curAmount - fruitTransaction.getQuantity();
        productDaoService.update(fruitTransaction, curAmount);
    }
}
