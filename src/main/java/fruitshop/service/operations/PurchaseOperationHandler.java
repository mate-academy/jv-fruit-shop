package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.OperationsDto;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String NO_FRUITS_TO_BUY_NOTIFICATION
            = "not enough fruits in the shop!";

    @Override
    public void applyOperation(OperationsDto data) {
        Map<Fruit,Integer> fruitStorage = FruitStorage.getStorage();
        Fruit fruit = data.getFruitType();
        Integer fruitsDemand = data.getAmount();
        if (fruitStorage.containsKey(fruit)) {
            Integer fruitLeftForSale = fruitStorage.get(fruit);
            Integer fruitsAfterPurchase = fruitLeftForSale - fruitsDemand;
            if (fruitsAfterPurchase < 0) {
                throw new RuntimeException(NO_FRUITS_TO_BUY_NOTIFICATION);
            }
            fruitStorage.replace(fruit, fruitLeftForSale, fruitsAfterPurchase);
        } else {
            throw new RuntimeException(NO_FRUITS_TO_BUY_NOTIFICATION);
        }
    }
}
