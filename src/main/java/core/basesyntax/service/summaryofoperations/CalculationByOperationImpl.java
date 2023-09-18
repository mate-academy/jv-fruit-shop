package core.basesyntax.service.summaryofoperations;

import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public class CalculationByOperationImpl implements Calculation {
    public int getSumByOperationDependsOnFruit(Map<Operation,
            Map<String, List<Integer>>> fruitStore, Operation operation, String fruit) {
        int sum =
                fruitStore.entrySet().stream()
                        .filter(entry -> entry.getKey() == operation)
                        .map(Map.Entry::getValue)
                        .filter(innerMap -> innerMap.containsKey(fruit))
                        .map(innerMap -> innerMap.get(fruit))
                        .flatMap(List::stream)
                        .mapToInt(Integer::intValue).sum();
        if (sum >= 0) {
            return sum;
        } else {
            throw new RuntimeException("Amount of fruit " + fruit + ", in operation "
                    + operation + " less then 0");
        }
    }
}
