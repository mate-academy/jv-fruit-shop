package core.basesyntax.service.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.strategy.OperationsHandler;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private final int indexOfOperationType;
    private final int indexOfFruitSort;
    private final int indexOfOperationsAmount;
    private final FruitService strategy;

    public DataProcessingServiceImpl(FruitService strategy, int indexOfOperationType,
                                     int indexOfFruitSort,
                                     int indexOfOperationsAmount) {
        this.strategy = strategy;
        this.indexOfOperationType = indexOfOperationType;
        this.indexOfFruitSort = indexOfFruitSort;
        this.indexOfOperationsAmount = indexOfOperationsAmount;
    }

    @Override
    public void processing(List<String> transactionsList) {
        OperationsHandler operationsHandler;
        ParserService parser = new ParserServiceImpl();
        List<String[]> transactions = parser.parseInputData(transactionsList);

        for (String[] transaction : transactions) {
            operationsHandler = strategy.getOperationStrategies(transaction[indexOfOperationType]);
            operationsHandler.operation(new FruitDto(transaction[indexOfFruitSort],
                    Integer.parseInt(transaction[indexOfOperationsAmount])));
        }
    }
}
