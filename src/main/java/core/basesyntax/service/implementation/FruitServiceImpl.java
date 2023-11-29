package core.basesyntax.service.implementation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

import java.util.List;

public class FruitServiceImpl implements FruitService {
    private StorageDao storageDao;

    public FruitServiceImpl(StorageDao storageDao){
        this.storageDao = storageDao;
    }

    @Override
    public void fillFruitStorage(List<String> dataFromFile){
        dataFromFile.forEach(string -> {
            String fruitName = string.split(",")[1];
            if (storageDao.get(fruitName) == null) {
                storageDao.add(createNewFruit(fruitName));
            }
        });
    }

    @Override
    public Fruit createNewFruit(String fruitName) {
            return new Fruit(fruitName);
    }
}
