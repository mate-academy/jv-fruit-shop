package strategy;

import dao.GenericDao;
import models.Fruit;

public class PurchaseOperationStrategy implements OperationStrategy {
    private GenericDao balanceService;

    public PurchaseOperationStrategy(GenericDao balanceService) {
        this.balanceService = balanceService;
    }

    @Override
    public void changeBalance(String item, Integer quantity) {
        balanceService.update(new Fruit(item), (quantity * -1));
    }
}
