package core.basesyntax.fruitsoperationsservice;

import core.basesyntax.model.Operation;
import java.util.List;

public interface FruitsOperationService {
    default List<Operation> prepareProcessedDataToReport() {
        return null;
    }
}
