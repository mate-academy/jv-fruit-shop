package core.basesyntax;

import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public PurchaseHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(Map<String, Integer> report, String fruit, int quantity) {
        int currentBalance = fruitStock.get(fruit);

        if (currentBalance < quantity) {
            throw new RuntimeException("Недостатньо фруктів для покупки: " + fruit);
        }
        fruitStock.updateFruitQuantity(fruit, currentBalance - quantity);
    }
}
