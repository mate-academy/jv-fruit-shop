package dao;

import db.FruitShop;
import java.time.LocalDate;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(Map<String, Integer> validMap) {
        FruitShop.fruitShop.put(LocalDate.now(), validMap);
    }
}
