package core.basesyntax.service;

import core.basesyntax.data.FruitData;
import java.util.List;

public interface DataParser {
    List<FruitData> parser(List<String> dataFromFile);
}
