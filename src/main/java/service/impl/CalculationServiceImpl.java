package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.CalculationService;
import service.CalculationStrategy;

public class CalculationServiceImpl implements CalculationService {
    private CalculationStrategy calculationStrategy;

    public CalculationServiceImpl(CalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruit : fruitTransactionList) {
            calculationStrategy.get(fruit.getOperation()).handle(fruit);
        }
    }
}
