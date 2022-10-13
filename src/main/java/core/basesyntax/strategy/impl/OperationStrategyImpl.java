package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private FruitDao fruitDao = new FruitDaoImpl();
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl() {
        operationHandlerMap
                = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao));
    }

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }
    
        public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlerMap() {
        return operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
