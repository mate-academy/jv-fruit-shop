package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.StorageUpdateService;
import java.util.List;
import java.util.Map;

public class CsvFormatDataProcessingServiceImpl implements DataProcessingService {
    private static final String CSV_SPLITERATOR = ",";
    private static final int OPERATION_IDX = 0;
    private static final int FRUIT_NAME_IDX = 1;
    private static final int AMOUNT_IDX = 2;
    private final Map<String, StorageUpdateService> strategyMap;

    public CsvFormatDataProcessingServiceImpl(Map<String, StorageUpdateService> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void processingData(List<String> dataSource) {
        dataSource.stream()
                .map(s -> s.split(CSV_SPLITERATOR))
                .filter(s -> strategyMap.containsKey(s[OPERATION_IDX]))
                .forEach(s -> strategyMap.get(s[OPERATION_IDX])
                        .update(new Fruit(s[FRUIT_NAME_IDX]), Integer.valueOf(s[AMOUNT_IDX])));
    }
}
