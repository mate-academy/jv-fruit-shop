package strategy;

import dto.Storage;
import exception.FruitShopException;
import model.CurrentBalance;

public class PurchaseStrategy implements ActivitiesStrategy {
    @Override
    public CurrentBalance doAction(Storage storage, CurrentBalance currentBalance) {
        Integer fruitBalance = currentBalance.balanceMap.get(storage.fruit);
        if (storage.quantity > fruitBalance) {
            throw new FruitShopException("Not enough " + storage.fruit.name + " to buy "
                    + storage.quantity + " items. Current balance is " + fruitBalance);
        }
        currentBalance.balanceMap.put(storage.fruit, fruitBalance - storage.quantity);
        return currentBalance;
    }
}
