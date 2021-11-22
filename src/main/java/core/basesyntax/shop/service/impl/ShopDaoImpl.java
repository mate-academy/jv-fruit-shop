package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.InsufficientGoodsException;
import core.basesyntax.shop.db.FruitShopStorage;
import core.basesyntax.shop.service.ShopDao;
import java.util.Map;

public class ShopDaoImpl implements ShopDao {

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
