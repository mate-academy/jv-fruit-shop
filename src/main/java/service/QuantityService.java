package service;

import java.util.List;
import model.FruitTransaction;

public interface QuantityService {
    public void calculateQuantityForFruits(List<FruitTransaction> fruitTransactions);
}
