package core.basesyntax.dao.operation;

import core.basesyntax.dao.storagedao.FruitStorageDao;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer useOperation(Integer quantity) {
        return quantity;
    }
}
