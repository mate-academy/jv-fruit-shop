package strategy;

import dao.GenericDao;
import models.Fruit;

public class PurchaseOperationHandler implements OperationStrategy {
    private GenericDao dao;

    public PurchaseOperationHandler(GenericDao dao) {
        this.dao = dao;
    }

    @Override
    public void changeBalance(String item, Integer quantity) {
        dao.update(new Fruit(item), (quantity * -1));
    }
}
