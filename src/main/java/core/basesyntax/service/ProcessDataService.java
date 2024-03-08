package core.basesyntax.service;

import core.basesyntax.factory.Factory;
import core.basesyntax.model.Fruit;
import java.util.List;

public interface ProcessDataService {
    void processData(List<Fruit> convert, Factory factory);
}
