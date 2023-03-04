package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public class OperationPurchaseImpl implements Operation {
    private final OperationBalanceImpl operationBalance = new OperationBalanceImpl();

    @Override
    public Map<String, Integer> startOperation(List<FruitTransaction> products) {
        Map<String, Integer> newMapForStorage = operationBalance.startOperation(products);
        for (FruitTransaction product : products) {
            if (product.getOperation().equals(FruitTransaction.Operation.PURCHASE)) {
                newMapForStorage.put(product.getFruit(),
                        newMapForStorage.get(product.getFruit()) - product.getQuantity());
            }
        }
        return newMapForStorage;
    }
}

