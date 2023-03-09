package core.basesyntax.impl;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.StorageService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService {
    private static final int ACTIVITY_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER = 1;
    private static final String PATTERN = ",";

    @Override
    public Map<String, Integer> createReport(List<String> data) {
        return data.stream()
                .skip(HEADER)
                .map(d -> d.split(PATTERN))
                .map(d -> new StorageTransaction(
                        getTypeActivity(d[ACTIVITY_INDEX]), d[FRUIT_INDEX],
                        Integer.parseInt(d[QUANTITY_INDEX])))
                .collect(Collectors.groupingBy(StorageTransaction::getFruit,
                        Collectors.summingInt(StorageTransaction::getQuantity)));
    }

    private TypeActivity getTypeActivity(String code) {
        return Arrays.stream(TypeActivity.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .get();
    }
}
