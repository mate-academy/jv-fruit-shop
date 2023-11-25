package strategy;

import db.FruitStorage;
import model.FruitTransaction;
import util.InsufficientInventoryException;

public class PurchaseStrategy implements TransactionStrategy {
    @Override
    public void apply(FruitStorage fruitStorage, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantityToPurchase = transaction.getQuantity();

        int currentInventory = fruitStorage.getQuantity(fruit);
        if (currentInventory < quantityToPurchase) {
            throw new InsufficientInventoryException(
                    "Not enough inventory to fulfill purchase for " + fruit
                            + ". Required: "
                            + quantityToPurchase
                            + ", Available: "
                            + currentInventory);
        }

        fruitStorage.subtractQuantity(fruit, quantityToPurchase);
    }
}
