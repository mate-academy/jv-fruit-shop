package core.fruitshop.service.strategy.impl;

import core.fruitshop.dao.FruitDao;
import core.fruitshop.dao.FruitDaoImpl;
import core.fruitshop.model.Fruit;
import core.fruitshop.service.CalculateHandler.Calculatehandler;
import core.fruitshop.service.CalculateHandler.CalculatehandlerImpl;
import core.fruitshop.service.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;
    private final Calculatehandler calculatehandler;

    public SupplyOperationHandler(FruitDao fruitDao,
        Calculatehandler calculatehandler) {
        this.fruitDao = fruitDao;
        this.calculatehandler = calculatehandler;
    }

    @Override
    public void doOperation(String fruitType, String quantity) {
        Fruit fruit = new Fruit(fruitType);
        calculatehandler.addQuantity(fruit, Integer.parseInt(quantity));
    }
}
