package solid.strategy.impl.operation;

import java.util.Map;
import solid.exception.ProductNotFoundException;
import solid.model.FruitTransaction;
import solid.strategy.OperationHandler;
import solid.strorage.FruitStorage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        isAvailability(transaction);
        for (Map.Entry<String, Integer> fruit : FruitStorage.fruits.entrySet()) {
            if (fruit.getKey().equals(transaction.getFruit())) {
                fruit.setValue(fruit.getValue() - transaction.getQuantity());
                break;
            }
        }
    }

    private void isAvailability(FruitTransaction transaction) {
        for (Map.Entry<String, Integer> fruit : FruitStorage.fruits.entrySet()) {
            if (fruit.getKey().equals(transaction.getFruit())) {
                if (fruit.getValue() < transaction.getQuantity()) {
                    throw new ProductNotFoundException("Not enough fruit, but you can buy "
                            + fruit.getValue());
                }
                return;
            }
        }
        throw new ProductNotFoundException("Sorry, but these fruits not available at the moment "
                + transaction.getFruit());
    }
}
