package core.basesyntax.service.processor;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface ServiceProcessorOfShop {
    void process(List<FruitRecord> transactions);
}
