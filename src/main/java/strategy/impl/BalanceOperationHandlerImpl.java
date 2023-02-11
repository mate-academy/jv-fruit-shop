package strategy.impl;

import db.FruitStorage;
import fruitscontent.FruitsContent;
import strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitsContent fruitsContent) {
        FruitStorage.fruits.put(fruitsContent.getFruit(), fruitsContent.getQuantity());
    }
}
