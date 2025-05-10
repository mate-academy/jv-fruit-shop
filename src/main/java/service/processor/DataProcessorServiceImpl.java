package service.processor;

import java.util.List;
import model.FruitRecord;
import service.strategy.TypeStrategy;

public class DataProcessorServiceImpl implements DataProcessorService {
    private TypeStrategy typeStrategy;

    public DataProcessorServiceImpl(TypeStrategy typeStrategy) {
        this.typeStrategy = typeStrategy;
    }

    @Override
    public void processData(List<FruitRecord> fruitRecords) {
        for (FruitRecord fruitRecord : fruitRecords) {
            typeStrategy.getType(fruitRecord.getOperation()).calculation(fruitRecord);
        }
    }
}
