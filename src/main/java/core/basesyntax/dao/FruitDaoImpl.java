package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;

public class FruitDaoImpl implements FruitDao {
    private FruitService fruitService = new FruitServiceImpl(this);

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String nameFruit) {
        boolean present = isPresent(nameFruit);
        if (!present) {
            return fruitService.createNewFruit(nameFruit);
        }
        return Storage.fruits.stream()
                .filter(f -> (f != null && f.getName().equals(nameFruit)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isPresent(String nameFruit) {
        return Storage.fruits.stream()
                .anyMatch(f -> (f != null && f.getName().equals(nameFruit)));
    }
}
