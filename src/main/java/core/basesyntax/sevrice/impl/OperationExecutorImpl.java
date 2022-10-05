package core.basesyntax.sevrice.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevrice.OperationExecutor;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.strategyimpl.BalanceOperationService;
import core.basesyntax.strategy.strategyimpl.PurchaseOperationService;
import core.basesyntax.strategy.strategyimpl.ReturnOperationService;
import core.basesyntax.strategy.strategyimpl.SupplyOperationService;
import java.util.HashMap;
import java.util.Map;

public class OperationExecutorImpl implements OperationExecutor {
    private FruitDao fruitDao = new FruitDaoImpl();
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap
            = new HashMap<>() {
                {
                    put(FruitTransaction.Operation.BALANCE, new BalanceOperationService(fruitDao));
                    put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationService(fruitDao));
                    put(FruitTransaction.Operation.SUPPLY, new SupplyOperationService(fruitDao));
                    put(FruitTransaction.Operation.RETURN, new ReturnOperationService(fruitDao));
                }
            };

    @Override
    public void execute(FruitTransaction transaction) {
        operationServiceMap.get(transaction.getOperation()).executeOperation(transaction);
    }
}
