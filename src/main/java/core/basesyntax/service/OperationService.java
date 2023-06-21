package core.basesyntax.service;

import core.basesyntax.model.ItemOperation;
import java.util.List;

public interface OperationService {
    List<ItemOperation> createOperationList(List<String> data);
}
