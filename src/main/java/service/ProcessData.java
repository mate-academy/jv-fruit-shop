package service;

import java.util.List;
import model.FruitTransaction;

public interface ProcessData {
    List<FruitTransaction> parseInputData(List<String> inputData);
}
