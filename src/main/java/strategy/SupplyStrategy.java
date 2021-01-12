package strategy;

import dto.Storage;
import model.CurrentBalance;

public class SupplyStrategy implements ActivitiesStrategy {
    @Override
    public CurrentBalance doAction(Storage storage, CurrentBalance currentBalance) {
        currentBalance.balanceMap.put(storage.fruit,
                currentBalance.balanceMap.get(storage.fruit) + storage.quantity);
        return currentBalance;
    }
}
