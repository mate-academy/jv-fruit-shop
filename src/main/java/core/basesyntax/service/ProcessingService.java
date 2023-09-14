package core.basesyntax.service;

import core.basesyntax.model.ItemOperation;
import java.util.List;

public interface ProcessingService {
    void processTransaction(List<ItemOperation> transactions);
}
