package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface DataConvertor {
    List<Fruit> convertData(List<String> readData);
}
