package fruit.shop.strategy;

import fruit.shop.db.Storage;

import java.util.List;

public class BalanceOperation implements OperationHandler {
    @Override
    public boolean calculateOperation(List<String> data) {
        for (String word : data) {
            String[] split = word.split(",");
            Storage.resultRemainder.put(split[1],Integer.parseInt(split[2]));
        }
        return true;
    }
}
