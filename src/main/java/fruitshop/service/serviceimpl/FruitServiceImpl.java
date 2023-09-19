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
    private final List<FruitTransaction> dataLinesObj;
    private final OperationStrategy operationStrategy;
    private OperationHandler operationService;

    public FruitServiceImpl(List<FruitTransaction> dataLines, Map<Operation, OperationHandler> operationHandlerMap) {
        operationStrategy = new OperationStrategy(operationHandlerMap);
        dataLinesObj = dataLines;
    }

    public void processFruits() {
        dataLinesObj.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .forEach(f -> Storage.getStorage().put(f, 0));
        countFruits();
    }

    private void countFruits() {
        dataLinesObj.forEach(l -> {
            operationService = operationStrategy.getOperationHandler(l.getOperation());
            int newAmount = operationService.doSomeOperation(Storage.getStorage().get(l.getFruit()),
                    l.getAmount());
            Storage.getStorage().put(l.getFruit(), newAmount);
        });
    }
}
