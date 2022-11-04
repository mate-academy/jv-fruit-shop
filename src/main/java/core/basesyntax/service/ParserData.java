package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserData {
    List<FruitTransaction> parseData(List<String> dataFromFile);
}
