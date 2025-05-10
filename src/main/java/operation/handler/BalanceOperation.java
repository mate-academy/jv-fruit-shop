package operation.handler;

import java.util.Map;
import transaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void operation(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
