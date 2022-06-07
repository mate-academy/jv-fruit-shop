package core.service.handlers;

import core.dao.FruitDao;

public class SupplyHandler implements OperationHandler {
    private FruitDao fruitService;

    public SupplyHandler(FruitDao fruitDao) {
        this.fruitService = fruitDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        int fruitsQuantityInStorage = fruitService.get(fruitName);
        fruitsQuantityInStorage += quantity;
        fruitService.update(fruitName,fruitsQuantityInStorage);
    }
}
