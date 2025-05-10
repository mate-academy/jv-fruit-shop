package service.processor;

import java.util.List;
import model.FruitRecord;

public interface DataProcessorService {
    void processData(List<FruitRecord> fruitRecords);
}
