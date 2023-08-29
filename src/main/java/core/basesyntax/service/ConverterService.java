package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ConverterService {
    List<Fruit> convert(List<String> list);
}
