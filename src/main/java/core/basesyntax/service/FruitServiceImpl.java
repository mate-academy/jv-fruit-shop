package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public String getFruit(String fruitName) {
        return Storage.remnantsOfGoods.keySet().stream()
                .filter(a -> a.equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addFruit(Map<String, Integer> remnantsOfGoods, String fruit, int quantity) {
        remnantsOfGoods.put(fruit, quantity);
    }

    @Override
    public void updateFruit(Map<String, Integer> remnantsOfGoods, String fruit, int addQuantity) {
        int mmm = remnantsOfGoods.get(fruit);
        remnantsOfGoods.put(fruit, mmm + addQuantity);
    }
}
