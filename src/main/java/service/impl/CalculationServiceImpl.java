package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.CalculationService;
import service.CalculationStrategy;
import service.OperationHandler;

public class CalculationServiceImpl implements CalculationService {
    private Map<Operation, OperationHandler> calculationHandlerMap;

    public CalculationServiceImpl(Map<Operation, OperationHandler> calculationHandlerMap) {
        this.calculationHandlerMap = calculationHandlerMap;
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactionList) {
        CalculationStrategy calculationStrategy =
                new CalculationStrategyImpl(calculationHandlerMap);
        for (FruitTransaction fruit : fruitTransactionList) {
            calculationStrategy.get(fruit.getOperation()).handle(fruit);
        }
    }
}
