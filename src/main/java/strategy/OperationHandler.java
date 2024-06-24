package strategy;

import db.Storage;
import model.FruitTransaction;

public interface OperationHandler {
    void applyOperation(FruitTransaction transaction);
}
