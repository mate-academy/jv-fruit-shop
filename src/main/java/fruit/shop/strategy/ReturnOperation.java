package fruit.shop.strategy;

import fruit.shop.db.Storage;
import java.util.List;

public class ReturnOperation implements OperationHandler {
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;

    @Override
    public boolean calculateOperation(List<String> data) {
        for (String word : data) {
            String[] split = word.split(",");
            Integer quantity = Storage.resultDB.get(split[INDEX_1]);
            Integer result = quantity + Integer.parseInt(split[INDEX_2]);
            if (result < 0) {
                throw new RuntimeException("Quantity is < 0 " + quantity);
            }
            Storage.resultDB.put(split[INDEX_1],result);
        }
        return true;
    }
}
