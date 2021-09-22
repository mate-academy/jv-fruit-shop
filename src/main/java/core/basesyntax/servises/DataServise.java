package core.basesyntax.servises;

import java.util.List;

public interface DataServise {
    List<String> report(OperationStrategy operationStrategy,
                        List<TransferDto> list, Storage<String, Integer> storage);
}
