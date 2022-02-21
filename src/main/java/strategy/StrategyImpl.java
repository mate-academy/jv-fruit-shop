package strategy;

import model.FruitModel;

public class StrategyImpl {
    private final OperationHandler operationHandler;

    public StrategyImpl(OperationHandler operationHandler) {
        this.operationHandler = operationHandler;
    }
    
    public boolean executeStrategy(FruitModel fruitModel) {
        return operationHandler.doOperation(fruitModel);
    }
}
