package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.RecordDto;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String NO_FRUITS_TO_BUY_NOTIFICATION
            = "not enough fruits in the shop!";

    @Override
    public void applyOperation(RecordDto data) {
        Fruit fruit = data.getFruitType();
        Integer fruitsDemand = data.getAmount();
        if (FruitStorage.getStorage().containsKey(fruit)) {
            Integer fruitLeftForSale = FruitStorage.getStorage().get(fruit);
            Integer fruitsAfterPurchase = fruitLeftForSale - fruitsDemand;
            if (fruitsAfterPurchase < 0) {
                throw new RuntimeException(NO_FRUITS_TO_BUY_NOTIFICATION);
            }
            FruitStorage.getStorage().replace(fruit, fruitLeftForSale, fruitsAfterPurchase);
        } else {
            throw new RuntimeException(NO_FRUITS_TO_BUY_NOTIFICATION);
        }
    }
}
