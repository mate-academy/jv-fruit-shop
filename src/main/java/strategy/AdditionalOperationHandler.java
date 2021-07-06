package strategy;

import dao.GenericDao;
import models.Fruit;

public class AdditionalOperationHandler implements OperationStrategy {
    private GenericDao dao;

    public AdditionalOperationHandler(GenericDao dao) {
        this.dao = dao;
    }

    public void changeBalance(String item, Integer quantity) {
        dao.update(new Fruit(item), quantity);
    }
}
