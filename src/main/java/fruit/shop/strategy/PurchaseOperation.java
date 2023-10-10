package fruit.shop.strategy;

import fruit.shop.db.Storage;

import java.util.List;

public class PurchaseOperation implements OperationHandler {
    @Override
    public boolean calculateOperation(List<String> data) {
        for (String word : data) {
            String[] split = word.split(",");
            Integer quantity = Storage.resultRemainder.get(split[1]);
            Integer result = quantity - Integer.parseInt(split[2]);
            Storage.resultRemainder.put(split[1],result);
        }
        return true;
    }
}
