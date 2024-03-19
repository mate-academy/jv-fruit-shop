package core.basesyntax.service.strategy;

import core.basesyntax.db.ChangedData;

public class ShopSupplyStrategy implements ShopActivityStrategy {
    private final ChangedData changedData;

    public ShopSupplyStrategy(ChangedData changedData) {
        this.changedData = changedData;
    }

    @Override
    public void workWithActivities(String fruit, int quantity) {
        int newQuantity = changedData.getChangedData().get(fruit) + quantity;
        changedData.getChangedData().put(fruit, newQuantity);
    }
}
