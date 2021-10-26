package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String,OperationHandler> operationHandlesMap = new HashMap<>();
    private FruitDao fruitDao;

    public OperationStrategyImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void get(String[] record) {
        operationHandlesMap.put("s",new AdditionOperationHandler(fruitDao));
        operationHandlesMap.put("p",new SubstractionOperationHandler(fruitDao));
        operationHandlesMap.put("r",new AdditionOperationHandler(fruitDao));
        operationHandlesMap.put("b",new AdditionOperationHandler(fruitDao));
        if (operationHandlesMap.get(record[0]) == null) {
            throw new RuntimeException("Invalid operation \"" + record[0] + "\"");
        }
        operationHandlesMap.get(record[0]).apply(record);
    }

}
