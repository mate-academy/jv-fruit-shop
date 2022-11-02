package core.basesyntax.service;

import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public interface ListProcessService {
    void processList(List<String> content, TransactionStrategy strategy);
}
