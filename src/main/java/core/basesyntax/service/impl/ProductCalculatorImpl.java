package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.OperationHandler;
import core.basesyntax.service.OperatorStrategy;
import core.basesyntax.service.ProductCalculator;
import java.util.List;

public class ProductCalculatorImpl implements ProductCalculator {
    private final OperatorStrategy operatorStrategy;

    public ProductCalculatorImpl(OperatorStrategy operatorStrategy) {
        this.operatorStrategy = operatorStrategy;
    }

    @Override
    public void calculateProducts(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler
                    = operatorStrategy.operatorHandler(fruitTransaction.getOperation());
            operationHandler.applyOperation(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
