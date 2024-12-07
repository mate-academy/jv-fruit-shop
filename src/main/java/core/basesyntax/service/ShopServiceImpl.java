package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        Map<String, FruitTransaction> calculatedTransactionsMap = new HashMap<>();

        for (FruitTransaction fruitTransaction : transactions) {
            if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE) {
                calculatedTransactionsMap.put(fruitTransaction.getFruit(), fruitTransaction);
            } else {
                FruitTransaction calculatedTransaction = calculatedTransactionsMap.get(fruitTransaction.getFruit());
                if (calculatedTransaction != null) {
                    operationStrategy.makeOperation(
                            fruitTransaction.getOperation(),
                            calculatedTransaction,
                            fruitTransaction.getQuantity()
                    );
                }
            }
        }

        transactions.clear();
        transactions.addAll(calculatedTransactionsMap.values());
    }

    public OperationStrategy getOperationStrategy() {
        return operationStrategy;
    }

    public void setOperationStrategy(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
}
