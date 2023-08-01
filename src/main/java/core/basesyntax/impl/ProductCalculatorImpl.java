package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.Operator;
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
            Operator operator = operatorStrategy.operatorHandler(fruitTransaction.getOperation());
            operator.doReportOperation(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
