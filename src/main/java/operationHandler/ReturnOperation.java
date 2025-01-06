package operationHandler;

import transaction.FruitTransaction;

import java.util.Map;

public class ReturnOperation implements OperationHandler{
    @Override
    public void operation(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
