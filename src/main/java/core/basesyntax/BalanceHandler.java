package core.basesyntax;

import java.util.Map;

public class BalanceHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public BalanceHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(Map<String, Integer> report, String fruit, int quantity) {
        int currentBalance = fruitStock.get(fruit);
        System.out.println("Поточний баланс для " + fruit + ": " + currentBalance);
        report.put(fruit, currentBalance);
    }
}
