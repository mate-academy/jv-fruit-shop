package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;

public class AmountCalculatorImpl implements AmountCalculator {
    private final OperationStrategy operationStrategy;

    public AmountCalculatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> calculateDataForReport(List<Operation> operations) {
        Map<String, Integer> fruitsStorage = new HashMap<>();
        for (Operation operation : operations) {
            int newAmount = operationStrategy.get(operation.getType())
                    .getAmount(operation, fruitsStorage);
            fruitsStorage.put(operation.getFruit(), newAmount);
        }
        return fruitsStorage;
    }
}
