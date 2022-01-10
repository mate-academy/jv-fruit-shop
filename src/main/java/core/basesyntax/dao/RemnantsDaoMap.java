package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.models.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class RemnantsDaoMap implements RemnantsDao {

    @Override
    public void addFruitRemnant(String fruitName, Long fruitRemnant) {
        Fruit fruitObject = new Fruit(fruitName);
        Storage.fruitsRemnants.put(fruitObject, fruitRemnant);
    }

    @Override
    public Long getFruitRemnant(String fruitName) {
        Fruit fruitObject = new Fruit(fruitName);
        return Storage.fruitsRemnants.get(fruitObject);
    }

    @Override
    public void updateFruitRemnant(String fruitName, Long newRemnant) {
        Fruit fruitObject = new Fruit(fruitName);
        if (Storage.fruitsRemnants.containsKey(fruitObject)) {
            Storage.fruitsRemnants.remove(fruitObject);
            Storage.fruitsRemnants.put(fruitObject, newRemnant);
        }
    }

    @Override
    public boolean fruitIsPresentInStorage(String fruitName) {
        Fruit fruitObject = new Fruit(fruitName);
        return Storage.fruitsRemnants.containsKey(fruitObject);
    }

    @Override
    public List<String> getRemnantsReportList() {
        return Storage.fruitsRemnants.entrySet().stream()
                .map(e -> e.getKey().getName() + ", " + e.getValue())
                .collect(Collectors.toList());
    }

}
