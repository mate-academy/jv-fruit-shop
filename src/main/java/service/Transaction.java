package service;

import java.util.List;
import model.Fruit;
import strategy.Strategy;

public class Transaction {

    public void transactionFruits(List<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            Strategy strategy = new Strategy();
            OperationService operationService = strategy.getOperationValue(fruit.getOperation());
            operationService.dataProcessing(fruit.getName(), fruit.getQuantity());
        }
    }
}
