package fruit.shop.service;

import fruit.shop.dao.ShopDaoImpl;
import fruit.shop.service.operation.BalanceOperation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShopDaoImpl shopDao = new ShopDaoImpl();
        List<String> strings = shopDao.get();
        strings.stream();


    }
}
