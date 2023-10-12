package fruit.shop.strategy;

import fruit.shop.db.Storage;
import java.util.List;

public class BalanceOperation implements OperationHandler {
    @Override
    public boolean calculateOperation(List<String> data) {
        if (data == null || data.isEmpty()) {
            return false;
        }
        for (String word : data) {
            String[] split = word.split(",");
            int quantity = Integer.parseInt(split[SECOND_INDEX]);
            OperationHandler.checkResult(quantity);
            Storage.resultDB.put(split[FIRST_INDEX],quantity);
        }
        return true;
    }
}
