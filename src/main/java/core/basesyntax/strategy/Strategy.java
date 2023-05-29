package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.Balance;
import core.basesyntax.strategy.impl.Purchase;
import core.basesyntax.strategy.impl.Return;
import core.basesyntax.strategy.impl.Supply;

import java.util.Map;

public class Strategy {
    private final Map<FruitTransaction.Operation,  OperationAnalysis> strategy;
    private final ProductDaoImpl productDao;

    public Strategy(ProductDaoImpl productDao) {
        this.strategy = Map.of(
                FruitTransaction.Operation.BALANCE,
                new Balance(productDao),
                FruitTransaction.Operation.SUPPLY,
                new Supply(productDao),
                FruitTransaction.Operation.RETURN,
                new Return(productDao),
                FruitTransaction.Operation.PURCHASE,
                new Purchase(productDao));
        this.productDao = productDao;
    }


    public OperationAnalysis get(FruitTransaction.Operation operation) {
        return strategy.get(operation);
    }
}
