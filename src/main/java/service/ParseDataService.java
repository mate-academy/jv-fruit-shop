package service;

import java.util.List;
import model.FruitTransaction;

public interface ParseDataService {
    List<FruitTransaction> parseData(List<String> list);
}
