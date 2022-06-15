package service.impl;

import dao.FruitDao;
import java.util.List;
import java.util.stream.Collectors;
import service.ShopService;

public class ShopServiceImpl implements ShopService {
    private final FruitDao fruitDao;

    public ShopServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String[]> doReport() {
        List<String[]> list = fruitDao.getAll().stream()
                .map(i -> new String[]{i.getKey(), String.valueOf(i.getValue())})
                .collect(Collectors.toList());
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
