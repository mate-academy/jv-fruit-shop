package core.basesyntax;

import java.util.Map;

public class ReturnHandler implements OperationHandler {
    private final Map<String, Integer> fruitInventory;

    public ReturnHandler(Map<String, Integer> fruitInventory) {
        this.fruitInventory = fruitInventory;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (fruitInventory.containsKey(fruit)) {
            fruitInventory.put(fruit, fruitInventory.get(fruit) + quantity);
            System.out.println("Повернення фруктів: " + quantity + " " + fruit);
        } else {
            fruitInventory.put(fruit, quantity);
            System.out.println("Додано новий фрукт до інвентаря: " + quantity + " " + fruit);
        }
    }
}
