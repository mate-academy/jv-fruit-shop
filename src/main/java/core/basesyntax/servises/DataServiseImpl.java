package core.basesyntax.servises;

import core.basesyntax.model.TransferDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataServiseImpl implements DataServise {
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> report(OperationStrategy operationStrategy,
                               List<TransferDto> list, Map<String, Integer> storage) {
        List<String> result = new ArrayList<>();
        for (TransferDto dto : list) {
            operationStrategy.get(dto.getType()).apply(dto, storage);
        }
        result.add(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            result.add(entry.getKey() + "," + entry.getValue());
        }
        return result;
    }
}
