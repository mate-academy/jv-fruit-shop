package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public class OperationSupplyImpl implements Operation {
    private final OperationReturnImpl operationReturn = new OperationReturnImpl();

    @Override
    public Map<String, Integer> startOperation(List<FruitTransaction> products) {
        Map<String, Integer> newMapForStorage = operationReturn.startOperation(products);
        for (FruitTransaction product : products) {
            if (product.getOperation().equals(FruitTransaction.Operation.SUPPLY)) {
                newMapForStorage.put(product.getFruit(),
                        newMapForStorage.get(product.getFruit()) + product.getQuantity());
            }
        }
        return newMapForStorage;
    }
}

