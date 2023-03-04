package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationBalanceImpl implements Operation {
    @Override
    public Map<String, Integer> startOperation(List<FruitTransaction> products) {
        Map<String, Integer> newMapForStorage = new HashMap<>();
        for (FruitTransaction product : products) {
            if (product.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
                newMapForStorage.put(product.getFruit(), product.getQuantity());
            }
        }
        return newMapForStorage;
    }
}

