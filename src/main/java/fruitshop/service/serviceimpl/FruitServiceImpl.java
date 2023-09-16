package fruitshop.service.serviceimpl;

import fruitshop.model.DataLine;
import fruitshop.service.FruitService;
import fruitshop.storage.Storage;
import fruitshop.strategy.OperationStrategy;
import fruitshop.strategy.operation.OperationService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final List<DataLine> dataLinesObj;
    private final OperationStrategy operationStrategy;
    private OperationService operationService;

    public FruitServiceImpl(List<DataLine> dataLines) {
        operationStrategy = new OperationStrategy();
        dataLinesObj = dataLines;
    }

    public void processFruits() {
        dataLinesObj.stream()
                .map(DataLine::getFruit)
                .distinct()
                .forEach(f -> Storage.getStorage().put(f, 0));
        countFruits();
    }

    private void countFruits() {
        dataLinesObj.forEach(l -> {
            operationService = operationStrategy.getCertainOperation(l.getOperation());
            int newAmount = operationService.doSomeOperation(Storage.getStorage().get(l.getFruit()),
                    l.getAmount());
            if (newAmount < 0) {
                throw new RuntimeException("Invalid data for amount, it should be more than 0."
                        + " Amounts: " + newAmount);
            }
            Storage.getStorage().put(l.getFruit(), newAmount);
        });
    }
}
