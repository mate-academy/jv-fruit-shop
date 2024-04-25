package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitOperationParser {
    List<FruitTransaction> parseFruitOperationList(List<String> listOfData);
}
