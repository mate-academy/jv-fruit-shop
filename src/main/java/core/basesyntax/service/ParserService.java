package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ParserService {
    List<Fruit> parseData(List<String> fruits);

}
