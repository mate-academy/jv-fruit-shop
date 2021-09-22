package core.basesyntax.operationhanlerservises;

import core.basesyntax.model.TransferDto;
import java.util.Map;

public interface OperationHandler {
    void apply(TransferDto transferDto, Map<String, Integer> map);
}
