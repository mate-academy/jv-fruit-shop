package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionParser {
    FruitTransaction parse(String line);

    List<FruitTransaction> parseLines(List<String> lines);
}
