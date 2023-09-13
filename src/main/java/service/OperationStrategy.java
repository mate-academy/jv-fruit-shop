package service;

import model.Fruit;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler update(Fruit fruit);
}
