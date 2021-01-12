package strategy;

import dto.Storage;
import model.CurrentBalance;

public class BalanceStrategy implements ActivitiesStrategy {
    @Override
    public CurrentBalance doAction(Storage storage, CurrentBalance currentBalance) {
        currentBalance.addBalance(storage.fruit, storage.quantity);
        return currentBalance;
    }
}
