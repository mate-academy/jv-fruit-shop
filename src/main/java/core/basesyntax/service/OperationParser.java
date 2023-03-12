package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationParser {
    List<FruitTransaction> parseOperation(List<String> data);
}
