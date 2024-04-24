package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import model.FruitOperation;
import model.FruitOperationType;
import model.FruitType;
import service.CalculateFruit;

public class CalculateFruitImpl implements CalculateFruit {
    private final Map<FruitType, Integer> fruitUniqueMap = new HashMap<>();

    public Map<FruitType, Integer> calcualteFruit(List<FruitOperation> listFruitOperation) {
        for (FruitOperation fruitOperation : listFruitOperation) {
            Integer newValue = calculateValue(fruitOperation.getOperationType(),
                    fruitOperation.getFruitType(), fruitOperation.getValue());
            fruitOperation.setValue(newValue);
            fruitUniqueMap.put(fruitOperation.getFruitType(), fruitOperation.getValue());
        }
        return fruitUniqueMap;
    }

    public Integer calculateValue(FruitOperationType fruitOperationType,
                                  FruitType fruitType, Integer value) {
        return switch (fruitOperationType) {
            case BALANCE -> value;
            case SUPPLY -> fruitUniqueMap.get(fruitType) + value;
            case PURCHASE -> fruitUniqueMap.get(fruitType) - value;
            case RETURN -> fruitUniqueMap.get(fruitType) + value;
            default -> throw new NoSuchElementException("OperationType "
                    + fruitOperationType + " no such");
        };
    }
}
