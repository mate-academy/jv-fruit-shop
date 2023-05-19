package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.QuantityCalculatorService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class QuantityCalculatorServiceImpl implements QuantityCalculatorService {
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private OperationHandlerStrategy operationServiceStrategy;
    private OperationHandler operationService;

    public QuantityCalculatorServiceImpl(OperationHandlerStrategy operationServiceStrategy) {
        this.operationServiceStrategy = operationServiceStrategy;
    }

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
