package core.service.handlers;

import core.dao.FruitDao;

public class PurchaseHandler implements OperationHandler {
    private FruitDao fruitService;

    public PurchaseHandler(FruitDao fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        int fruitsQuantityInStorage = fruitService.get(fruitName);
        fruitsQuantityInStorage -= quantity;
        fruitService.update(fruitName,fruitsQuantityInStorage);
    }
}
