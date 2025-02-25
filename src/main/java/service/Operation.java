package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface Operation {
    Map<String, Integer> update(List<FruitTransaction> data);
}
