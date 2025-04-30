package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(ShopService shopService, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityReturned = fruitTransaction.getQuantity();
        int currentQuantity = shopService.getReportData().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantityReturned;
        shopService.updateStorage(fruit, newQuantity);
    }
}
