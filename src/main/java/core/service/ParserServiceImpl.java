package core.service;

import core.FruitTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String CHAR_FOR_SPLIT = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        return dataFromFile.stream()
                .map(s -> s.split(CHAR_FOR_SPLIT))
                .map(strings -> new FruitTransaction(Arrays.stream(FruitTransaction
                                .Activity.values())
                        .filter(o -> o.getOperation().equals(strings[INDEX_OPERATION]))
                        .findFirst()
                        .get(),
                        strings[INDEX_FRUIT],
                        Integer.parseInt(strings[INDEX_COUNT])))
                .collect(Collectors.toList());
    }
}
