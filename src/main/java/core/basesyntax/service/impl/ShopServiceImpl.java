package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import java.util.HashMap;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    @Override
    public Map<String, Integer> process(Map<FruitTransaction.Operation,
            Map<String, Integer>> fruitTransactions) {
        Map<String, Integer> fruitsQuantityAfterDay = new HashMap<>();
        Map<String, Integer> balanceList = fruitTransactions
                .get(FruitTransaction.Operation.BALANCE);
        balanceList.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, Integer::sum));
        Map<String, Integer> supplyList = fruitTransactions
                .get(FruitTransaction.Operation.SUPPLY);
        supplyList.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, Integer::sum));
        Map<String, Integer> purchaseList = fruitTransactions
                .get(FruitTransaction.Operation.PURCHASE);
        purchaseList.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, (oldValue, newValue) -> oldValue - newValue));
        Map<String, Integer> returnList = fruitTransactions
                .get(FruitTransaction.Operation.RETURN);
        returnList.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, Integer::sum));
        return fruitsQuantityAfterDay;
    }
}
