package service.dao;

import java.util.List;
import model.FruitTransaction;

public interface ParserFrom {
    List<FruitTransaction> parsedToFruitTransaction(List<String> fromFile);
}
