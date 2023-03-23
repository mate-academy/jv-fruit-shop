package core.basesyntax.service.impl.handlers;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandlerService;

public class BalanceHandlerServiceImpl implements OperationHandlerService {
    private StorageDaoImpl storageDaoImpl;

    @Override
    public void addData(Fruit fruit, int quantity) {
        storageDaoImpl.add(fruit, quantity);
    }
}

