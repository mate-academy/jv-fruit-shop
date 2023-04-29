package service.impl;

import static db.StorageTotalBalance.fruitStorageTotalBalance;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.CalculationService;
import service.CalculationStrategy;
import service.FruitCalculation;

public class CalculationServiceImpl implements CalculationService {
    private List<FruitTransaction> fruitTransactionList;

    public CalculationServiceImpl(List<FruitTransaction> fruitTransactionList) {
        this.fruitTransactionList = fruitTransactionList;
    }

    @Override
    public Map<String, Integer> calculate(Map<Operation, FruitCalculation> calculationHandlerMap) {
        CalculationStrategy calculationStrategy =
                new CalculationStrategyImpl(calculationHandlerMap);
        for (FruitTransaction fruit : fruitTransactionList) {
            calculationStrategy.get(fruit.getOperation()).fruitStorageCalculation(fruit);
        }
        return fruitStorageTotalBalance;
    }
}
