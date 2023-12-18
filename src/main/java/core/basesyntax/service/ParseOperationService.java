package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseOperationService {
    List<FruitTransaction> parseContentForOperations(List<String> inputData);
}