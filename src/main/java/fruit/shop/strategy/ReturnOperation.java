package fruit.shop.strategy;

import fruit.shop.db.Storage;
import java.util.List;

public class ReturnOperation implements OperationHandler {
    @Override
    public boolean calculateOperation(List<String> data) {
        if (data == null || data.isEmpty()) {
            return false;
        }
        for (String word : data) {
            String[] split = word.split(",");
            Integer quantity = Storage.resultDB.get(split[FIRST_INDEX]);
            Integer result = quantity + Integer.parseInt(split[SECOND_INDEX]);
            OperationHandler.checkResult(result);
            Storage.resultDB.put(split[FIRST_INDEX],result);
        }
        return true;
    }
}
