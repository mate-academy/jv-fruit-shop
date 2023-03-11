package core.basesyntax.service.impl;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.DataParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    public static final int ACTIVITY_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String PATTERN = ",";

    @Override
    public List<StorageTransaction> parse(List<String> data) {
        return data.stream()
                .map(d -> d.split(PATTERN))
                .map(d -> new StorageTransaction(
                        getTypeActivity(d[ACTIVITY_INDEX]), d[FRUIT_INDEX],
                        Integer.parseInt(d[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    private StorageTransaction.TypeActivity getTypeActivity(String code) {
        return Arrays.stream(StorageTransaction.TypeActivity.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .get();
    }
}
