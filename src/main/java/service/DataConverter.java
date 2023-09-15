package service;

import java.util.List;
import model.FruitTransaction;

public interface DataConverter {
    List<FruitTransaction> fruitList(List<String> inputInfo);
}
