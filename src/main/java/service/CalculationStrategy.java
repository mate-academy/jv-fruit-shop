package service;

import model.Operation;

public interface CalculationStrategy {
    FruitCalculation get(Operation operation);
}
