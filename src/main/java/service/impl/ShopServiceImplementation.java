package service.impl;

import java.util.List;
import service.FruitDao;
import service.ShopService;

public class ShopServiceImplementation implements ShopService {
    private final FruitDao fruitDao;

    public ShopServiceImplementation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String[]> doReport() {
        List<String[]> list = fruitDao.getBalance();
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
