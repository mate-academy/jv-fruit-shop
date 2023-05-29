package service;

import java.util.List;
import model.FruitTransaction;

// Interface for parsing the file.
public interface FileParser {
    List<FruitTransaction> getFruitTransaction(List<String> activity);
}
