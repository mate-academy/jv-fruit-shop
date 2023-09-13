package service;

import java.util.List;
import model.FruitTransaction;

public interface Parser {
    List<FruitTransaction> parseFile(List<String> fileContent);
}
