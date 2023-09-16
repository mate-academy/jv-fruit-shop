package service;

import java.util.List;
import model.FruitTransaction;

public interface InputTextService {
    List<FruitTransaction> processInputText(List<String> inputFromFile);
}
