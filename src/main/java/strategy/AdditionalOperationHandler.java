package strategy;

import db.GenericDao;
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
