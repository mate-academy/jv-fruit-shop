package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Calculator;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.OperationServiceStrategy;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private OperationServiceStrategy operationServiceStrategy = new OperationServiceStrategy();
    private OperationService operationService;

    public List<String> calculate(List<FruitTransaction> fruitTransactions) {
        int appleTotalQuantity = 0;
        int bananaTotalQuantity = 0;
        for (FruitTransaction transaction : fruitTransactions) {
            if (transaction.getFruit().equals(BANANA)) {
                operationService = operationServiceStrategy
                        .getOperationService(transaction.getOperation().getCode());
                bananaTotalQuantity = operationService
                        .doCalculation(bananaTotalQuantity, transaction.getQuantity());
            } else {
                operationService = operationServiceStrategy
                        .getOperationService(transaction.getOperation().getCode());
                appleTotalQuantity = operationService
                        .doCalculation(appleTotalQuantity, transaction.getQuantity());
            }
        }
        return List.of(BANANA, String.valueOf(bananaTotalQuantity),
                       APPLE, String.valueOf(appleTotalQuantity));
    }
}
