package operation.handler;

import java.util.Map;
import transaction.FruitTransaction;

public interface OperationHandler {
    void operation(FruitTransaction transaction, Map<String, Integer> storage);
}
