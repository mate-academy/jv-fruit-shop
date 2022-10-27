package core.basesyntax.service.impl;

import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void getReport(StringBuilder data) {
        String[] dataToArray = data.toString().split(System.lineSeparator());
        for (String lineInArr : dataToArray) {
            String[] arrWithOperatorAndFruitQuantity = lineInArr.split(COMMA);
            String operation = arrWithOperatorAndFruitQuantity[OPERATION_INDEX];
            String fruitName = arrWithOperatorAndFruitQuantity[FRUIT_NAME_INDEX];
            String quantity = arrWithOperatorAndFruitQuantity[QUANTITY_INDEX];
            OperationService operationService = operationStrategy.getOperation(operation);
            operationService.getResultBalance(fruitName, Integer.parseInt(quantity));
        }
    }
}
