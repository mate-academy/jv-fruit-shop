package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private final Map<String, Integer> fruitQuantities = new HashMap<>();

    public void processTransaction(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();
        String fruit = transaction.getFruit();
        switch (transaction.getOperation()) {
            case BALANCE:
                setQuantity(fruit, quantity);
                break;
            case SUPPLY:
                addQuantity(fruit, quantity);
                break;
            case PURCHASE:
                subtractQuantity(fruit, quantity);
                break;
            case RETURN:
                addQuantity(fruit, quantity);
                break;
            default:
                throw new RuntimeException("Unknown operation: " + transaction.getOperation());
        }
    }

    public void setQuantity(String fruit, int quantity) {
        fruitQuantities.put(fruit, quantity);
    }

    public void addQuantity(String fruit, int quantity) {
        fruitQuantities.merge(fruit, quantity, Integer::sum);
    }

    public void subtractQuantity(String fruit, int quantity) {
        fruitQuantities.merge(fruit, -quantity, Integer::sum);
    }

    public void generateReport() {
        System.out.println("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    public Map<String, Integer> getFruitQuantities() {
        return fruitQuantities;
    }
}
