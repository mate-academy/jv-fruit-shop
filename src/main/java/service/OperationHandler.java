package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    Map<String, Integer> update(List<FruitTransaction> data);
}
