package core.basesyntax.service.impl.handlers;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandlerService;

public class PurchaseHandlerServiceImpl implements OperationHandlerService {
    private StorageDaoImpl storageDaoImpl;

    @Override
    public void addData(Fruit fruit, int quantity) {
        int balance = storageDaoImpl.getQuantity(fruit) - quantity;
        if (balance >= 0) {
            storageDaoImpl.add(fruit, balance);
        }
        throw new RuntimeException("Quantity of purchase can't be bigger then balance in storage: storage - "
                + balance + " purchase - "
                + quantity);
    }
}
