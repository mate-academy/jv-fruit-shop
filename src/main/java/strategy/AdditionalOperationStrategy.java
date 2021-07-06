package strategy;

import dao.GenericDao;
import models.Fruit;

public class AdditionalOperationStrategy implements OperationStrategy {
    private GenericDao balanceService;

    public AdditionalOperationStrategy(GenericDao balanceService) {
        this.balanceService = balanceService;
    }

    public void changeBalance(String item, Integer quantity) {
        balanceService.update(new Fruit(item), quantity);
    }
}
