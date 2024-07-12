package service;

import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Map<String, Integer> storage);
}
