package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlesMap = new HashMap<>();
    private FruitDao fruitDao;

    public OperationStrategyImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void get(String[] record) {
        operationHandlesMap.put("s",new SupplyOperationHandler(fruitDao));
        operationHandlesMap.put("p",new PurchaseOperationHandler(fruitDao));
        operationHandlesMap.put("r",new ReturnOperationHandler(fruitDao));
        operationHandlesMap.put("b",new BalanceOperationHandler(fruitDao));
        if (operationHandlesMap.get(record[0]) == null) {
            throw new RuntimeException("Invalid operation \"" + record[0] + "\"");
        }
        operationHandlesMap.get(record[0]).apply(record);
    }

}
