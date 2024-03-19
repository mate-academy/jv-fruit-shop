package core.basesyntax.service.strategy;

import core.basesyntax.db.ChangedData;

public class ShopBalanceStrategy implements ShopActivityStrategy {
    private final ChangedData changedData;

    public ShopBalanceStrategy(ChangedData changedData) {
        this.changedData = changedData;
    }

    @Override
    public void workWithActivities(String fruit, int quantity) {
        changedData.getChangedData().put(fruit,quantity);
    }
}
