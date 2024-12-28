package core.basesyntax.service;

import core.basesyntax.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> process(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            FruitTransaction calculatedTransaction =
                    Storage.calculatedTransactions.get(fruitTransaction.getFruit());
            if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE
            && !Storage.calculatedTransactions.containsKey(fruitTransaction.getFruit())) {
                if (calculatedTransaction != null) {
                    operationStrategy.makeOperation(
                            fruitTransaction.getOperation(),
                            calculatedTransaction,
                            fruitTransaction.getQuantity()
                    );
                }
                Storage.calculatedTransactions.put(fruitTransaction.getFruit(), fruitTransaction);
            } else {
                if (calculatedTransaction != null) {
                    operationStrategy.makeOperation(
                            fruitTransaction.getOperation(),
                            calculatedTransaction,
                            fruitTransaction.getQuantity()
                    );
                }
            }
        }

        return Storage.calculatedTransactions.values().stream().collect(Collectors.toList());
    }
}
