package strategy;

import db.Storage;

public interface OperationStrategy {
    public void handleOperation(Storage fruitStorage);
}
