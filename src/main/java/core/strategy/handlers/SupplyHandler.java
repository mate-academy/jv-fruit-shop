package core.strategy.handlers;

import core.service.FruitService;

public class SupplyHandler implements OperationHandler {
    private FruitService fruitService;

    public SupplyHandler(FruitService fruitDao) {
        this.fruitService = fruitDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        int fruitsQuantityInStorage = fruitService.get(fruitName);
        fruitsQuantityInStorage += quantity;
        fruitService.update(fruitName,fruitsQuantityInStorage);
    }
}
