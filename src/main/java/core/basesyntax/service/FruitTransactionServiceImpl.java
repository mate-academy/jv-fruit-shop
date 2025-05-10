package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentQuantity = fruitStorage.getOrDefault(fruit, 0);

        try {
            switch (transaction.getOperation()) {
                case BALANCE:
                    fruitStorage.put(fruit, quantity);
                    break;
                case SUPPLY:
                    fruitStorage.put(fruit, currentQuantity + quantity);
                    break;
                case PURCHASE:
                    if (currentQuantity < quantity) {
                        throw new IllegalArgumentException("Insufficient quantity for fruit: "
                                + fruit);
                    }
                    fruitStorage.put(fruit, currentQuantity - quantity);
                    break;
                case RETURN:
                    fruitStorage.put(fruit, currentQuantity + quantity);
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported operation: "
                            + transaction.getOperation());
            }
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            System.err.println("Error processing transaction for fruit "
                    + fruit + ": " + e.getMessage());
        }
    }

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
