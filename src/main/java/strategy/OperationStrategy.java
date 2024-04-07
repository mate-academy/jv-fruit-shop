package strategy;

import model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface OperationStrategy {
    void apply(List<String> operation, Map<FruitTransaction.Operation, OperationStrategy> quantity);
}
