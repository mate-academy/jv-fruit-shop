package core.shop.service;

import core.shop.model.FruitTransaction;
import java.util.List;

public interface CalculateQuantityService {
    void calculate(List<FruitTransaction> fruitTransactions);
}
