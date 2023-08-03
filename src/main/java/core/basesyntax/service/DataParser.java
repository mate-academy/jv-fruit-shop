package core.basesyntax.service;

import core.basesyntax.model.FruitActivity;
import java.util.List;

public interface DataParser {
    List<FruitActivity> processFile(List<String> lines);
}
