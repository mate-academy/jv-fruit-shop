package dao;

import db.FruitShop;

import java.time.LocalDate;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(String validList) {
        FruitShop.fruitShop.put(LocalDate.now(), validList);
    }
}
