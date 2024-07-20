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
            if (!fruitTransactionComputed.containsKey(fruitTransaction.getFruit())) {
                fruitTransactionComputed.put(fruitTransaction.getFruit(),
                        fruitTransaction.getQuantity());
            } else if (fruitTransactionComputed.containsKey(fruitTransaction.getFruit())) {
                int value = fruitTransactionComputed.get(fruitTransaction.getFruit());
                fruitTransactionComputed
                        .replace(fruitTransaction.getFruit(),
                                value,
                                value + fruitTransaction.getQuantity());
            }
        }
        return fruitTransactionComputed;
    }
}
