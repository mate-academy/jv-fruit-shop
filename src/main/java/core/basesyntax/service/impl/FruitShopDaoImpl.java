package core.basesyntax.service.impl;

import core.basesyntax.service.FruitShopDao;
import java.util.HashMap;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    private Map<String, Integer> balanceMap;
    private Map<String, Integer> supplyMap;
    private Map<String, Integer> purchaseMap;
    private Map<String, Integer> returnMap;

    @Override
    public Map<String, Integer> getAllFruitsAndQuantities() {
        Map<String, Integer> fruitsQuantityAfterDay = new HashMap<>();
        balanceMap.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, Integer::sum));
        supplyMap.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, Integer::sum));
        purchaseMap.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, (oldValue, newValue) -> oldValue - newValue));
        returnMap.forEach((key, value) -> fruitsQuantityAfterDay
                .merge(key, value, Integer::sum));
        return fruitsQuantityAfterDay;
    }

    @Override
    public void setBalanceMap(Map<String, Integer> balanceMap) {
        this.balanceMap = balanceMap;
    }

    @Override
    public void setSupplyMap(Map<String, Integer> supplyMap) {
        this.supplyMap = supplyMap;
    }

    @Override
    public void setPurchaseMap(Map<String, Integer> purchaseMap) {
        this.purchaseMap = purchaseMap;
    }

    @Override
    public void setReturnMap(Map<String, Integer> returnMap) {
        this.returnMap = returnMap;
    }
}
