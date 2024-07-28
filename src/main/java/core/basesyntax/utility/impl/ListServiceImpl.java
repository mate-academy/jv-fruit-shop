package core.basesyntax.utility.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utility.ListService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListServiceImpl implements ListService {
    @Override
    public Map<String, Integer> getComputedMap(List<FruitTransaction> fruitTransactionList) {
        Map<String, Integer> fruitTransactionComputed = new HashMap<>();
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            fruitTransactionComputed.merge(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity(), Integer::sum);
        }
        return fruitTransactionComputed;
    }
}
