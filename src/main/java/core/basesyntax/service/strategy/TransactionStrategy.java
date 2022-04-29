package core.basesyntax.service.strategy;

import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;

public interface TransactionStrategy {
    Parser.OperationHandler get(LineData lineData);
}
