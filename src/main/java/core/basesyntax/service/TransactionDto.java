package core.basesyntax.service;

import core.basesyntax.service.operationTypes.OperationStrategy;

import java.util.List;

public class TransactionDto {
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    public void convertFromListToDb(List<String> fruitsData, OperationStrategy strategy) {
        for (int i = 1; i < fruitsData.size(); i++) {
            String[] fruitInfo = fruitsData.get(i).split(SEPARATOR);
            strategy.get(fruitInfo[OPERATION_TYPE])
                    .makeOperation(fruitInfo[FRUIT_TYPE], Integer.parseInt(fruitInfo[AMOUNT]));
        }
    }
}
