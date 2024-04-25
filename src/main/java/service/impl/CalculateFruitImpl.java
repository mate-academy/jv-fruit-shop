package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitOperation;
import model.FruitType;
import service.CalculateFruit;
import strategy.impl.FruitOperationHandler;

public class CalculateFruitImpl implements CalculateFruit {
    private final FruitOperationHandler operationHandler;
    private final Map<FruitType, Integer> fruitUniqueMap = new HashMap<>();

    public CalculateFruitImpl() {
        operationHandler = new FruitOperationHandler();
    }

    public Map<FruitType, Integer> calculateFruit(List<FruitOperation> listFruitOperation) {
        for (FruitOperation fruitOperation : listFruitOperation) {
            Integer newValue = operationHandler.executeOperation(
                    fruitOperation.getOperationType(),
                    fruitUniqueMap.getOrDefault(fruitOperation.getFruitType(), 0),
                    fruitOperation.getValue()
            );
            fruitUniqueMap.put(fruitOperation.getFruitType(), newValue);
            fruitOperation.setValue(newValue);
        }
        return fruitUniqueMap;
    }
}















//public class CalculateFruitImpl implements CalculateFruit {
//    private final Map<FruitType, Integer> fruitUniqueMap = new HashMap<>();
//
//    public Map<FruitType, Integer> calcualteFruit(List<FruitOperation> listFruitOperation) {
//        for (FruitOperation fruitOperation : listFruitOperation) {
//            Integer newValue = calculateValue(fruitOperation.getOperationType(),
//                    fruitOperation.getFruitType(), fruitOperation.getValue());
//            fruitOperation.setValue(newValue);
//            fruitUniqueMap.put(fruitOperation.getFruitType(), fruitOperation.getValue());
//        }
//        return fruitUniqueMap;
//    }
//
//    public Integer calculateValue(FruitOperationType fruitOperationType,
//                                  FruitType fruitType, Integer value) {
//        return switch (fruitOperationType) {
//            case BALANCE -> value;
//            case SUPPLY -> fruitUniqueMap.get(fruitType) + value;
//            case PURCHASE -> fruitUniqueMap.get(fruitType) - value;
//            case RETURN -> fruitUniqueMap.get(fruitType) + value;
//            default -> throw new NoSuchElementException("OperationType "
//                    + fruitOperationType + " no such");
//        };
//    }
//}
