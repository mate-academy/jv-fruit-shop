package fruitshop.service;

import fruitshop.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);

}