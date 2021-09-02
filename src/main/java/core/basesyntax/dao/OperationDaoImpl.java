package core.basesyntax.dao;

import core.basesyntax.db.OperationsStorage;
import core.basesyntax.model.Operation;

public class OperationDaoImpl implements OperationDao {
    @Override
    public void put(String type, String fruit, int amount) {
        Operation operation = new Operation(type, fruit, amount);
        OperationsStorage.getOperationList().add(operation);
    }
}
