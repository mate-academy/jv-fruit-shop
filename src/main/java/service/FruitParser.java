package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitParser {
    List<FruitTransaction> parse(List<String> lines);

    FruitTransaction parseTransaction(String line);
}

