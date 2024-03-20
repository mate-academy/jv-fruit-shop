package core.basesyntax.service.impl;

import core.basesyntax.db.BalanceStorage;
import core.basesyntax.dto.ActivityDto;
import core.basesyntax.exception.NegativeQuantityException;
import core.basesyntax.model.Product;
import core.basesyntax.service.BalanceUpdater;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyHandler;
import java.util.List;

public class BalanceUpdaterImpl implements BalanceUpdater {
    private final BalanceStorage balanceStorage;
    private final ActivityStrategyHandler activityHandler;

    public BalanceUpdaterImpl(BalanceStorage balanceStorage) {
        this.balanceStorage = balanceStorage;
        activityHandler = new ActivityStrategyHandler();
    }

    public void updateFrom(List<ActivityDto> activities) {
        for (var activity : activities) {
            Product product = new Product(activity.productTitle());
            int oldQuantity = balanceStorage.getQuantity(product);
            int newQuantity = calculateQuantity(oldQuantity, activity);
            if (newQuantity < 0) {
                throw new NegativeQuantityException("Received negative quantity: " + newQuantity);
            }
            balanceStorage.save(product, newQuantity);
        }
    }

    private int calculateQuantity(int oldQuantity, ActivityDto activity) {
        ActivityStrategy activityStrategy = activityHandler.get(activity.type());
        return activityStrategy.calculateQuantity(oldQuantity, activity.productQuantity());
    }
}
