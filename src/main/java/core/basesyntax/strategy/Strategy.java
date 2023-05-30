package core.basesyntax.strategy;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.Map;

public class Strategy {
    private final Map<FruitTransaction.Operation, OperationProcessor> strategy;
    private final StorageImpl productDao;

    public Strategy(StorageImpl productDao) {
        this.strategy = Map.of(
                FruitTransaction.Operation.BALANCE,
                new BalanceOperation(productDao),
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(productDao),
                FruitTransaction.Operation.RETURN,
                new ReturnOperation(productDao),
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(productDao));
        this.productDao = productDao;
    }

    public OperationProcessor get(FruitTransaction.Operation operation) {
        return strategy.get(operation);
    }
}
