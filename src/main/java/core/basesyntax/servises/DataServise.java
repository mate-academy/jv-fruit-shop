package core.basesyntax.servises;

import core.basesyntax.model.TransferDto;
import java.util.List;
import java.util.Map;

public interface DataServise {
    List<String> report(OperationStrategy operationStrategy,
                        List<TransferDto> list, Map<String, Integer> storage);
}
