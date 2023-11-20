package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface FruitService {
    Map<String, Integer> processData(List<FruitTransaction> dataFromCsv);
}
