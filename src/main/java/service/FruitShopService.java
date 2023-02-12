package service;

import fruitscontent.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void processOfOperations(List<FruitTransaction> parsedData);
}
