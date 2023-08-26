package service.storage;

import java.util.Map;
import model.FruitTransaction;

public interface PerformingOperation {
    void performToReport(FruitTransaction record, Map<String,Integer> repport);

}
