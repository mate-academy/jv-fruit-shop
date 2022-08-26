package services;

import java.util.List;
import model.FruitTransaction;

public interface OperationProcessor {
    void process(List<FruitTransaction> data);
}
