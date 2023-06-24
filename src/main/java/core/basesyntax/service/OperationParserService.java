package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationParserService {
    List<FruitTransaction> parseOperation(List<String> data);
}
