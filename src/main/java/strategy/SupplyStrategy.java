package strategy;

import model.FruitTransaction;

import java.util.List;
import java.util.Map;

public class SupplyStrategy implements OperationStrategy {
    @Override
    public void apply(List<String> operation, Map<FruitTransaction.Operation, OperationStrategy> quantity) {

    }
}
