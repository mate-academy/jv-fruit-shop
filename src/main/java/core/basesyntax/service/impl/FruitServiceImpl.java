package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final ProcessDataService processDataService = new ProcessDataServiceImpl();
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculateFruits(String filePath) {
        List<String> inputData = processDataService.readData(filePath);
        List<FruitTransaction> fruitTransactions = processDataService.saveData(inputData);
        for (FruitTransaction transaction: fruitTransactions) {
            operationStrategy.get(transaction.getOperation()).getOperation(transaction);
        }
    }
}
