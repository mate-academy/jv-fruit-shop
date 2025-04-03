package core.basesyntax;

import java.util.Map;

public class ReturnHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public ReturnHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(Map<String, Integer> report, String fruit, int quantity) {
        fruitStock.add(fruit, quantity);
        report.put(fruit, report.getOrDefault(fruit, 0) + quantity);
    }
}
