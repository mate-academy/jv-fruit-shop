package core.basesyntax.service;

import core.basesyntax.controller.ControllerDao;
import core.basesyntax.controller.ControllerDaoImpl;
import core.basesyntax.model.CreateStrategy;
import core.basesyntax.model.CreateStrategyImpl;
import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private ControllerDao<Fruit> controllerDao = new ControllerDaoImpl();
    private CreateStrategy<Fruit> createStrategy = new CreateStrategyImpl();

    public boolean supplyFruit(String fruitType,
                               int count, LocalDate expirationDate) {
        for (int i = 0; i < count; i++) {
            if (!controllerDao.put(createStrategy.createFruit(fruitType, expirationDate))) {
                return false;
            }
        }
        return true;
    }

    public boolean buyFruit(String fruitType,
                            int count, LocalDate purchaseDate) {
        List<Fruit> fruitList = controllerDao.getAll();
        for (int i = 0; i < fruitList.size(); i++) {
            if (count == 0) {
                break;
            }
            if (fruitList.get(i).getClass().getSimpleName().equalsIgnoreCase(fruitType)) {
                if (fruitList.get(i).getExDate().isBefore(purchaseDate)) {
                    return false;
                }
                controllerDao.get(i);
                count--;
            }
        }
        return true;
    }

    public boolean returnFruit(String fruitType,
                               int count, LocalDate expirationDate) {
        return supplyFruit(fruitType, count, expirationDate);
    }
}
