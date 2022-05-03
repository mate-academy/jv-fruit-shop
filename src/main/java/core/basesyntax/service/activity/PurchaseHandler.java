package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(Fruit fruit) {
        if (fruitDao.getByName(fruit.getName()) != null) {
            fruitDao.subtractAmount(fruit);
        } else {
            throw new RuntimeException("Error in input data. "
                    + "It's impossible to sell a non-existent product");
        }
    }
}

