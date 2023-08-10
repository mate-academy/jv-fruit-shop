package service;

import java.util.List;
import model.FruitTransaction;

public interface ParserService {

    String getHeader();

    List<FruitTransaction> parseData(List<String> data);
}
