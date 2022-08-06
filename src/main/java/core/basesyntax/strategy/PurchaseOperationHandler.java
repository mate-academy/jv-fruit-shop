package core.basesyntax.strategy;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoHashMap;

public class PurchaseOperationHandler implements OperationHandler {
    private final Dao dao;

    public PurchaseOperationHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void performOperation(String fruit, Integer quantity) {
        Integer newQuantity = dao.getQuantity(fruit) - quantity;
        if (newQuantity < 0) {
            System.out.println("After purchase " + fruit + " quantity " + quantity
                    + " the balance is negative");
        }

        new DaoHashMap().add(fruit, newQuantity);
    }
}
