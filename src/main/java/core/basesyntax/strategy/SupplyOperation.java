package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(ShopService shopService, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantitySupplied = fruitTransaction.getQuantity();
        int currentQuantity = shopService.getReportData().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantitySupplied;
        shopService.updateStorage(fruit, newQuantity);
    }
}
