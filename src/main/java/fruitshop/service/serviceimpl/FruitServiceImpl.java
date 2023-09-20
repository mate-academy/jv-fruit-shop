package fruitshop.service.serviceimpl;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.service.FruitService;
import fruitshop.storage.Storage;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;
    private OperationHandler operationService;

    public FruitServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        operationStrategy = new OperationStrategy(operationHandlerMap);
    }

    public void processFruits(List<FruitTransaction> dataLinesObj) {
        dataLinesObj.forEach(l -> {
            operationService = operationStrategy.getOperationHandler(l.getOperation());
            int newAmount;
            newAmount = operationService
                    .doSomeOperation(Storage.getStorage().getOrDefault(l.getFruit(), 0),
                    l.getAmount());
            Storage.getStorage().put(l.getFruit(), newAmount);
        });
    }
}
