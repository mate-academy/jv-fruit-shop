package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitService {

    List<String> transaction(List<FruitTransaction> fruitList);

    List<String> createReport(List<String> fruits, String header);
}
