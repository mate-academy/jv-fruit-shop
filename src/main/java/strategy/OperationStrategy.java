package strategy;

import model.Fruit;
import service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Fruit.TypeOperation type);
}
