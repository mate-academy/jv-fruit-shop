package operationHandler;

import transaction.FruitTransaction;

import java.util.Map;

public interface OperationHandler {
    void operation (FruitTransaction transaction, Map<String, Integer> storage);
}
