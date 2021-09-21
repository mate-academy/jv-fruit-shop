package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.storage.Storage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitShopServiceImpl implements FruitShopService {
    private Map<String, Integer> fruitsBalanceStatistic = new HashMap<>(Storage.fruitBalance);

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        Set<Map.Entry<String, Integer>> entries = fruitsBalanceStatistic.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            stringBuilder.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
