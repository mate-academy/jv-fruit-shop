package service;

import java.util.List;
import model.FruitTransaction;

public interface ParserService {
    List<FruitTransaction> parseData(List<String> data);
}
