package operation.handler;

import java.util.Map;
import transaction.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
