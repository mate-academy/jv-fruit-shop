package core.basesyntax.services;

import core.basesyntax.model.FruitRecordDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataServiceImpl implements DataService {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> generateReport(OperationStrategy operationStrategy,
                                       List<FruitRecordDto> list, Map<String, Integer> storage) {
        List<String> result = new ArrayList<>();
        for (FruitRecordDto dto : list) {
            operationStrategy.get(dto.getType()).apply(dto, storage);
        }
        result.add(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            result.add(entry.getKey() + SEPARATOR + entry.getValue());
        }
        return result;
    }
}
