package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitParser {
    Fruit parse(List<String> parameters);
}
