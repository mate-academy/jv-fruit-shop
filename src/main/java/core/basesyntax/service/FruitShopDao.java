package core.basesyntax.service;

import java.util.Map;

public interface FruitShopDao {
    Map<String, Integer> getAllFruitsAndQuantities();

    void setBalanceMap(Map<String, Integer> balanceMap);

    void setSupplyMap(Map<String, Integer> supplyMap);

    void setPurchaseMap(Map<String, Integer> purchaseMap);

    void setReturnMap(Map<String, Integer> returnMap);
}
