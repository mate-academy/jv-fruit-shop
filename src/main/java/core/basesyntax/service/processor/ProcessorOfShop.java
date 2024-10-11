package core.basesyntax.service.processor;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface ProcessorOfShop {
    void process(List<FruitRecord> transactions);
}
