package core.basesyntax.shop.dao;

import core.basesyntax.shop.db.FruitShopStorage;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void add(String item, int quantity) {
        if (FruitShopStorage.getFruitShopMap().containsKey(item)) {
            FruitShopStorage.getFruitShopMap().put(
                    item, FruitShopStorage.getFruitShopMap().get(item) + quantity);
        } else {
            FruitShopStorage.getFruitShopMap().put(item, quantity);
        }
    }

    @Override
    public void subtract(String item, int quantity) throws InsufficientGoodsException {
        if (FruitShopStorage.getFruitShopMap().containsKey(item)
                && FruitShopStorage.getFruitShopMap().get(item) > quantity) {
            FruitShopStorage.getFruitShopMap().put(item,
                    FruitShopStorage.getFruitShopMap().get(item) - quantity);
            return;
        }
        throw new InsufficientGoodsException("Not enough " + item);
    }

    @Override
    public Map<String, Integer> returnMap() {
        return FruitShopStorage.getFruitShopMap();
    }
}
