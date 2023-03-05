package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.Map;

public class FruitsCalculatorStrategy {
    int get(int quantityBefore, int quantityAfter, FruitTransaction.Operation operation){
        return 0;
    }
    private Map<FruitTransaction.Operation, OperationStrategy>map(){
        Map<FruitTransaction.Operation, OperationStrategy>map = new HashMap<>();
        return map;
    }
}
