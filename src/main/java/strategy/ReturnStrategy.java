package strategy;

import dto.Storage;
import model.CurrentBalance;

public class ReturnStrategy implements ActivitiesStrategy {
    @Override
    public CurrentBalance doAction(Storage storage, CurrentBalance currentBalance) {
        Integer fruitBalance = currentBalance.balanceMap.get(storage.fruit);
        currentBalance.balanceMap.put(storage.fruit, fruitBalance + storage.quantity);
        return currentBalance;
    }
}
