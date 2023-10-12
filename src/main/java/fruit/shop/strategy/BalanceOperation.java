package fruit.shop.strategy;

import fruit.shop.db.Storage;
import java.util.List;

public class BalanceOperation implements OperationHandler {
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;

    @Override
    public boolean calculateOperation(List<String> data) {
        for (String word : data) {
            String[] split = word.split(",");
            int quantity = Integer.parseInt(split[INDEX_2]);
            if (quantity < 0) {
                throw new RuntimeException("Quantity is < 0 " + quantity);
            }
            Storage.resultDB.put(split[INDEX_1],quantity);
        }
        return true;
    }
}
