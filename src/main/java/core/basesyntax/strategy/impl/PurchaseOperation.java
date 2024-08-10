package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Instruction;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class PurchaseOperation implements Operation {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(Instruction instruction) {
        if (!storageDao.contains(instruction.getFruitName())) {
            throw new OperationException("Fruit " + instruction.getFruitName()
                    + " doesn't exist");
        }
        storageDao.add(instruction.getFruitName(),
                storageDao.get(instruction.getFruitName()) - instruction.getQuantity());
    }
}
