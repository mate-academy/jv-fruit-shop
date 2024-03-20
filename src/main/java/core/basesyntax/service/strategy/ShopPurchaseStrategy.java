package core.basesyntax.service.strategy;

import core.basesyntax.db.CurrentData;

public class ShopPurchaseStrategy implements ShopActivityStrategy {
    private final CurrentData currentData;

    public ShopPurchaseStrategy(CurrentData currentData) {
        this.currentData = currentData;
    }

    @Override
    public void workWithActivities(String fruit, int quantity) {
        int newQuantity = currentData.getChangedData().get(fruit) - quantity;
        currentData.getChangedData().put(fruit, newQuantity);
    }
}
