package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> reportData = new HashMap<>();
        while (!fruitTransactions.isEmpty()) {
            FruitTransaction fruitTransaction = fruitTransactions.remove(0);
            if (fruitTransaction.getQuantity() < 0) {
                throw new RuntimeException("Quantity could not be les then 0! "
                        + "Please check input data!!");
            }
            reportData.merge(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity(),
                    (oldValue, newValue) -> {
                    newValue = operationStrategy.getOperation(fruitTransaction
                                    .getOperation()).makeOperation(newValue);
                    int result = oldValue + newValue;
                        if (result < 0) {
                            throw new RuntimeException("You couldn't sell more fruits then you "
                                    + "have, please check your input data!"
                                    + " Fruit: " + fruitTransaction.getFruit()
                                    + " Quantity: " + fruitTransaction.getQuantity()
                                    + " Balance: " + oldValue);
                        }
                        return result;
                    });

        }
        return reportData;
    }
}
