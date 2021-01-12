package servise;

import dto.Activities;
import dto.Storage;
import exception.FruitShopException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.CurrentBalance;
import strategy.ActivitiesStrategy;
import strategy.BalanceStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;

public class ActivitiesHandler {
    private final Map<Activities, ActivitiesStrategy> activityMap;
    private final BalanceStrategy balanceStrategy;
    private final SupplyStrategy supplyStrategy;
    private final PurchaseStrategy purchaseStrategy;
    private final ReturnStrategy returnStrategy;

    public ActivitiesHandler() {
        activityMap = new HashMap<>();
        balanceStrategy = new BalanceStrategy();
        activityMap.put(Activities.BALANCE, balanceStrategy);
        supplyStrategy = new SupplyStrategy();
        activityMap.put(Activities.SUPPLY, supplyStrategy);
        purchaseStrategy = new PurchaseStrategy();
        activityMap.put(Activities.PURCHASE, purchaseStrategy);
        returnStrategy = new ReturnStrategy();
        activityMap.put(Activities.RETURN, returnStrategy);
    }

    public CurrentBalance handle(List<Storage> storagesList, CurrentBalance currentBalance) {
        boolean isBalanceStorageHandled = false;
        for (Storage storage : storagesList) {
            if (isBalanceStorageHandled) {
                if (storage.action.equals(Activities.BALANCE)) {
                    throw new FruitShopException(
                            "Banalce activity line found in the middle of the file");
                }
            } else {
                if (!storage.action.equals(Activities.BALANCE)) {
                    isBalanceStorageHandled = true;
                }
            }
            activityMap.get(storage.action).doAction(storage, currentBalance);
        }
        return currentBalance;
    }
}
