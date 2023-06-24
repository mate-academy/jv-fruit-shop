package core.basesyntax.service.impl;

import static java.lang.Integer.parseInt;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParseService;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataParseServiceImpl implements DataParseService {
    public static final int ACTIVITY_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String PATTERN = ",";

    @Override
    public List<FruitTransaction> getParsedData(List<String> data) {
        return data.stream()
                .map(line -> line.split(PATTERN))
                .map(strings -> new FruitTransaction(getTypeActivity(strings[ACTIVITY_INDEX]),
                        strings[FRUIT_INDEX], parseInt(strings[QUANTITY_INDEX])))
                .collect(Collectors.toList());

    }

    public FruitTransaction.Operation getTypeActivity(String code) {
        Optional<FruitTransaction.Operation> first =
                Arrays.stream(FruitTransaction.Operation.values())
                .filter(type -> type.getCode().equals(code))
                .findFirst();
        return first.orElseThrow(() -> new NoSuchElementException("Can't find such element"));
    }
}
