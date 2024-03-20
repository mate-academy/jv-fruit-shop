package core.basesyntax.service.strategy;

import core.basesyntax.db.CurrentData;

public class ShopBalanceStrategy implements ShopActivityStrategy {
    private final CurrentData currentData;

    public ShopBalanceStrategy(CurrentData currentData) {
        this.currentData = currentData;
    }

    @Override
    public void workWithActivities(String fruit, int quantity) {
        currentData.getChangedData().put(fruit,quantity);
    }
}
