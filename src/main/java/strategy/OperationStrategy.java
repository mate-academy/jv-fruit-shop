package strategy;

import fruitscontent.FruitsContent;

public interface OperationStrategy {
    OperationHandler get(FruitsContent.Operation operation);
}
