package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionParser {
    List<FruitTransaction> parseList(List<String> data);
}
