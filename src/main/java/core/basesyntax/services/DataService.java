package core.basesyntax.services;

import core.basesyntax.model.TransferDto;
import java.util.List;
import java.util.Map;

public interface DataService {
    List<String> report(OperationStrategy operationStrategy,
                        List<TransferDto> list, Map<String, Integer> storage);
}
