package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;

public class SupplyOperation extends AddOperation {
    public SupplyOperation(FruitStorageDao fruitStorageDao) {
        super(fruitStorageDao);
    }
}
