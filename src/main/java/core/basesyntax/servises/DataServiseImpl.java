package core.basesyntax.servises;

import java.util.ArrayList;
import java.util.List;

public class DataServiseImpl implements DataServise {

    @Override
    public List<String> report(OperationStrategy operationStrategy,
                               List<TransferDto> list, Storage<String, Integer> storage) {
        List<String> result = new ArrayList<>();
        for (TransferDto dto : list) {
            operationStrategy.get(dto.getType()).apply(dto, storage);
        }
        result.add(storage.entrySet().toString());
        return result;
    }
}
