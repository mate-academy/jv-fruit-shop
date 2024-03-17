package service;

import model.FruitTransaction;
import strategy.FruitStrategy;

import java.util.List;
import java.util.Map;

public interface FruitService {
    public void processTransaction(Map<List<FruitTransaction>, FruitStrategy> strategies);
}
