package core.basesyntax.service.operation;

import java.util.List;

public interface OperationParser {
    List<FruitOperation> getFruitTransaction(List<String> transactionData);
}
