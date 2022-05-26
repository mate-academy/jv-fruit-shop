package service.implementation;

import dao.FruitDao;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import service.FruitService;
import storage.Storage;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void add(String fruitName, Integer amount) {
        fruitDao.add(fruitName, amount);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return fruitDao.getQuantity(fruitName);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits.entrySet().stream()
                .map(f -> new Fruit(f.getKey(), f.getValue()))
                .collect(Collectors.toList());
    }
}
