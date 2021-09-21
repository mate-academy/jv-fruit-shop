package core.basesyntax.services.calculation;

import core.basesyntax.model.Operation;
import core.basesyntax.services.operation.Strategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmountCalculatorImpl implements AmountCalculator {
    private final Strategy strategy;

    public AmountCalculatorImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> calculateDataForReport(List<Operation> operations) {
        Map<String, Integer> fruitsStorage = new HashMap<>();
        for (Operation operation : operations) {
            int newAmount = strategy.get(operation.getType())
                    .getAmount(operation, fruitsStorage);
            fruitsStorage.put(operation.getFruit(), newAmount);
        }
        return fruitsStorage;
    }
}
