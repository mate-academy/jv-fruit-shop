package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitCalculator {
    void calculateFruit(List<FruitTransaction> listFruitTransaction);
}
