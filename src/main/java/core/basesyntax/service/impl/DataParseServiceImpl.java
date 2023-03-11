package core.basesyntax.service.impl;

import static java.lang.Integer.parseInt;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.DataParseService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParseServiceImpl implements DataParseService {
    public static final int ACTIVITY_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String PATTERN = ",";

    @Override
    public List<StorageTransaction> getParsedData(List<String> data) {
        return data.stream()
                .map(d -> d.split(PATTERN))
                .map(strings -> new StorageTransaction(getTypeActivity(strings[ACTIVITY_INDEX]),
                        strings[FRUIT_INDEX], parseInt(strings[QUANTITY_INDEX])))
                .collect(Collectors.toList());

    }

    public StorageTransaction.Operation getTypeActivity(String code) {
        return Arrays.stream(StorageTransaction.Operation.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .get();
    }
}
