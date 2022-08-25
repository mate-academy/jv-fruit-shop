package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CalculateOperation;

public class ReturnOperationImpl implements CalculateOperation {
    private SupplyOperationImpl supplyOperation;

    public ReturnOperationImpl(SupplyOperationImpl supplyOperation) {
        this.supplyOperation = supplyOperation;
    }

    @Override
    public void getCalculateFruit(Fruit fruit, int amount) {
        supplyOperation.getCalculateFruit(fruit, amount);
    }
}
