package service.dao;

import java.util.List;
import model.FruitTransaction;

public interface ParserReader {
    List<FruitTransaction> parsedToFruitTransaction(List<String> fromFile);
}
