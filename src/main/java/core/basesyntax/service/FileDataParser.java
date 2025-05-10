package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileDataParser {
    List<FruitTransaction> parseData(List<String> dataFromFile);
}
