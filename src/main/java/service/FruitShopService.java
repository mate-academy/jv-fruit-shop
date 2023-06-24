package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopService {
    void calculate(List<FruitTransaction> list);
}
