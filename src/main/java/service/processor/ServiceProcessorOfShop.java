package service.processor;

import model.FruitRecord;

import java.util.List;

public interface ServiceProcessorOfShop {
    void process(List<FruitRecord> transactions);
}
