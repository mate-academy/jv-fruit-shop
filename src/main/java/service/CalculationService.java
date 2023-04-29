package service;

import java.util.Map;
import model.Operation;

public interface CalculationService {
    Map<String, Integer> calculate(Map<Operation, FruitCalculation> calculationHandlerMap);
}
