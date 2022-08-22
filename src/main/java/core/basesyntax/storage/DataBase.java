package core.basesyntax.storage;

import core.basesyntax.model.FruitsMovement;

import java.util.List;

public abstract class DataBase {
    protected List<FruitsMovement> movementOfFruits;

    public abstract List<FruitsMovement> getAllTransactions();
}
