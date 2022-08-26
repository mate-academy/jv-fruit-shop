package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface TransactionParser {
    List<FruitOperation> parseDataFile(List<String> data);
}
