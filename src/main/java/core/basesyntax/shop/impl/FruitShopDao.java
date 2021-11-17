package core.basesyntax.shop.impl;

import core.basesyntax.shop.InsufficientGoodsException;
import core.basesyntax.shop.ShopDao;
import java.util.Map;

public class FruitShopDao implements ShopDao {

    @Override
    public void add(String item, int quantity) {
        if (FruitShopStorage.FRUIT_SHOP_MAP.containsKey(item)) {
            FruitShopStorage.FRUIT_SHOP_MAP.put(
                    item, FruitShopStorage.FRUIT_SHOP_MAP.get(item) + quantity);
        } else {
            FruitShopStorage.FRUIT_SHOP_MAP.put(item, quantity);
        }
    }

    @Override
    public void subtract(String item, int quantity) throws InsufficientGoodsException {
        if (FruitShopStorage.FRUIT_SHOP_MAP.containsKey(item)
                && FruitShopStorage.FRUIT_SHOP_MAP.get(item) > quantity) {
            FruitShopStorage.FRUIT_SHOP_MAP.put(item,
                    FruitShopStorage.FRUIT_SHOP_MAP.get(item) - quantity);
            return;
        }
        throw new InsufficientGoodsException("Not enough " + item);
    }

    @Override
    public Map<String, Integer> returnMap() {
        return FruitShopStorage.FRUIT_SHOP_MAP;
    }
}
