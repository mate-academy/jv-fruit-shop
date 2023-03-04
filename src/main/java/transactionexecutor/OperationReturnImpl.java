package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public class OperationReturnImpl implements Operation {
    private final OperationPurchaseImpl operationPurchase = new OperationPurchaseImpl();

    @Override
    public Map<String, Integer> startOperation(List<FruitTransaction> products) {
        Map<String, Integer> newMapForStorage = operationPurchase.startOperation(products);
        for (FruitTransaction product : products) {
            if (product.getOperation().equals(FruitTransaction.Operation.RETURN)) {
                newMapForStorage.put(product.getFruit(),
                        newMapForStorage.get(product.getFruit()) + product.getQuantity());
            }
        }
        return newMapForStorage;
    }
}
