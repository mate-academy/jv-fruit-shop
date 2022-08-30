package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    public static final int INDEX_OF_TYPE = 0;
    public static final int INDEX_OF_FRUITS = 1;
    public static final int INDEX_OF_QUANTITY = 2;
    public static final String REGEX_STRING = ",";
    public static final String FIRST_FILE_LINE_INDEX = "type";

    @Override
    public List<FruitTransaction> parse(List<String> fruitsData) {
        return fruitsData.stream()
                .map(s -> s.split(REGEX_STRING))
                .filter(s -> !s[INDEX_OF_TYPE].equals(FIRST_FILE_LINE_INDEX))
                .map(strings -> new FruitTransaction(
                        getOperation(strings[INDEX_OF_TYPE]),
                        strings[INDEX_OF_FRUITS],
                        Integer.parseInt(strings[INDEX_OF_QUANTITY])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String operation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst()
                .get();
    }
}
