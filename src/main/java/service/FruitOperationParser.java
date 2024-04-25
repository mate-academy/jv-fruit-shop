package service;

import java.util.List;
import model.FruitOperation;

public interface FruitOperationParser {
    List<FruitOperation> parseFruitOperationList(List<String> listOfData);
}
