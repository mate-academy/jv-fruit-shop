package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParsedStringInFile {
    List<FruitTransaction> parse(List<String> dataFromFile);
}
