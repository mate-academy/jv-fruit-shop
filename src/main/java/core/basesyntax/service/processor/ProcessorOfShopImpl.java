package core.basesyntax.service.processor;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.TypeStrategy;
import java.util.List;

public class ProcessorOfShopImpl implements ProcessorOfShop {
    private TypeStrategy typeStrategy;

    public ProcessorOfShopImpl(TypeStrategy typeStrategy) {
        this.typeStrategy = typeStrategy;
    }

    @Override
    public void process(List<FruitRecord> transactions) {
        for (FruitRecord fruitRecord : transactions) {
            typeStrategy.getType(fruitRecord.getOperation()).apply(fruitRecord);
        }
    }

}
