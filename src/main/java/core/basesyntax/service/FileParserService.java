package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileParserService {
    List<FruitTransaction> getFruitTransaction(List<String> fruitsDataFromFile);
}
