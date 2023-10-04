package core.basesyntax.service;

import core.basesyntax.model.FruitModel;
import java.util.List;

public interface ParserService {
    List<FruitModel> parseData(List<String> strings);
}
