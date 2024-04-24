package service;

import java.util.List;
import model.FruitOperation;

public interface FruitOperationParse {
    List<FruitOperation> parseFruitOperationList(List<String> listOfData);
}
