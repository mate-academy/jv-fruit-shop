package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Instruction;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class BalanceOperation implements Operation {
    private StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(Instruction instruction) {
        if (storageDao.contains(instruction.getFruitName())) {
            throw new OperationException("Fruit " + instruction.getFruitName()
                    + " already exist");
        }
        storageDao.add(instruction.getFruitName(), instruction.getQuantity());
    }
}
