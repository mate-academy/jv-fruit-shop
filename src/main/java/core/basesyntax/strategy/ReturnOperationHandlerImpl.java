package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.Optional;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        FruitTransaction fruit = FruitStorage.getFruit(fruitName).get();
        fruit = Optional.ofNullable(fruit)
                .orElseThrow(() -> new RuntimeException(
                        "Fruit not found: " + fruitName));
        fruit.setQuantity(fruit.getQuantity() + quantity);
    }
}

