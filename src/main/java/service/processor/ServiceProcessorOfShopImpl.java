package service.processor;

import model.FruitRecord;
import service.strategy.TypeStrategy;

import java.util.List;

public class ServiceProcessorOfShopImpl implements ServiceProcessorOfShop {
    private TypeStrategy typeStrategy;

    public ServiceProcessorOfShopImpl(TypeStrategy typeStrategy) {
        this.typeStrategy = typeStrategy;
    }

    @Override
    public void process(List<FruitRecord> transactions) {
        for (FruitRecord fruitRecord : transactions) {
            typeStrategy.getType(fruitRecord.getOperation()).apply(fruitRecord);
        }
    }

}
