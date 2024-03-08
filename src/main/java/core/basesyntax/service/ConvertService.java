package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ConvertService {
    List<Fruit> convert(List<String> data);
}
