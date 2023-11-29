package core.basesyntax.service.implementation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String COMMA = ",";
    private static final int FRUIT_INDEX = 1;
    private final StorageDao storageDao;

    public FruitServiceImpl() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void fillFruitStorage(List<String> dataFromFile) {
        dataFromFile.forEach(string -> {
            String fruitName = string.split(COMMA)[FRUIT_INDEX];
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
