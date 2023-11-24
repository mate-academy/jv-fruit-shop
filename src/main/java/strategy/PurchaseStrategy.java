package strategy;

import model.FruitStorage;
import model.FruitTransaction;
import service.InsufficientInventoryException;

public class PurchaseStrategy implements TransactionStrategy {
    @Override
    public void apply(FruitStorage fruitStorage, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantityToPurchase = transaction.getQuantity();

        int currentInventory = fruitStorage.getFruitInventory().get(fruit);
        if (currentInventory < quantityToPurchase) {
            throw new InsufficientInventoryException(
                    "Not enough inventory to fulfill purchase for " + fruit
                            + ". Required: "
                            + quantityToPurchase
                            + ", Available: "
                            + currentInventory);
        }

        fruitStorage.getFruitInventory().merge(fruit, -quantityToPurchase, Integer::sum);
    }
}
