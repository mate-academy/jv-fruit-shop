package service;

import java.util.List;
import model.FruitTransaction;

public interface DataConverter {
    List<FruitTransaction> convertData(List<String> fruitOperations);
}
