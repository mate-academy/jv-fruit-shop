package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy os) {
        this.operationStrategy = os;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactionList) {
        Storage storage = new Storage();
        Map<String, Integer> fruitMap = storage.createStorage(transactionList);
        for (FruitTransaction transaction : transactionList) {
            String fruitName = transaction.getFruit().getName();
            Integer newValue = fruitMap.get(fruitName) + operationStrategy
                    .getService(transaction.getOperation())
                    .calculateOperation(transaction.getQuantity());
            fruitMap.put(fruitName, newValue);
        }
        return fruitMap;
    }
}
