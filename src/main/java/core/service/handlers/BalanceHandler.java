package core.service.handlers;

import core.dao.FruitDao;

public class BalanceHandler implements OperationHandler {
    private FruitDao fruitService;

    public BalanceHandler(FruitDao fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        fruitService.update(fruitName,quantity);
    }
}
