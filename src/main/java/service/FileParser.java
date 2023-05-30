package service;

import java.util.List;
import model.FruitTransaction;

public interface FileParser {
    List<FruitTransaction> getFruitTransaction(List<String> activity);
}
