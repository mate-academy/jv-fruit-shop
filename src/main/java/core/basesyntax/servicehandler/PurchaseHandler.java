package core.basesyntax.servicehandler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseHandler implements FruitOperationHandler {
    private final Map<String, Integer> fruitStorage;

    public PurchaseHandler(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = fruitStorage.getOrDefault(transaction.getFruit(), 0);
        if (currentQuantity - transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Brak wystarczającej ilości owoców: "
                    + transaction.getFruit() + ". Dostępna ilość: "
                    + currentQuantity + ", żądana ilość: " + transaction.getQuantity());
        }
        fruitStorage.put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}
