package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.interfaces.Operation;
import core.basesyntax.model.Fruit;
import java.util.List;

public class AddOperation implements Operation {
    private FruitDao fruitDao = new FruitDaoImpl();

    public List<Fruit> apply(Transaction fruitsFromFile) {
        for (int i = 0; i < fruitsFromFile.getAmount(); i++) {
            fruitDao.add(new Fruit(fruitsFromFile.getTypeOfFruit(),
                    fruitsFromFile.getExpirationDate()));
        }
        return fruitDao.getAll();
    }
}
