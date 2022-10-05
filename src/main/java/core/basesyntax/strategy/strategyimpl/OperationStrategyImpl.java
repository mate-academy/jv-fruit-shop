package core.basesyntax.strategy.strategyimpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private FruitDao fruitDao = new FruitDaoImpl();
    private final Map<FruitTransaction.Operation, OperationHandler> operationServiceMap
            = new HashMap<>() {
                {
                    put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao));
                    put(FruitTransaction.Operation.PURCHASE,
                            new PurchaseOperationHandler(fruitDao));
                    put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
                    put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao));
                }
            };

    @Override
    public void execute(FruitTransaction transaction) {
        operationServiceMap.get(transaction.getOperation()).executeOperation(transaction);
    }
}
