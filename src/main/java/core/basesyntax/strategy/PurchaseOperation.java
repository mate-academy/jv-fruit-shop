package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(ShopService shopService, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityToBuy = fruitTransaction.getQuantity();
        int currentQuantity = shopService.getReportData().getOrDefault(fruit, 0);

        if (currentQuantity >= quantityToBuy) {
            shopService.reduceStorage(fruit, quantityToBuy);
        } else {
            throw new RuntimeException("Not enough "
                    + fruit + " available for purchase. Current stock: " + currentQuantity);
        }
    }
}
