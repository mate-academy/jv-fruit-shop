package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final DataProcessService dataProcessService;
    private final DataReaderService dataReaderService;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy,
                            DataReaderService dataReaderService,
                            DataProcessService dataProcessService) {
        this.operationStrategy = operationStrategy;
        this.dataReaderService = dataReaderService;
        this.dataProcessService = dataProcessService;

    }

    @Override
    public void calculateFruits(String filePath) {
        List<String> inputData = dataReaderService.readData(filePath);
        List<FruitTransaction> fruitTransactions = dataProcessService.processData(inputData);
        for (FruitTransaction transaction: fruitTransactions) {
            operationStrategy.get(transaction.getOperation()).getOperation(transaction);
        }
    }
}
