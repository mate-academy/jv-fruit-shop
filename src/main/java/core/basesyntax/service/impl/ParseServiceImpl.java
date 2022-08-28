package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .map(s -> s.split(","))
                .map(value -> new FruitTransaction(
                        Arrays.stream(FruitTransaction.Operation.values())
                                .filter(o -> o.getOperation().equals(value[INDEX_OF_OPERATION]))
                                .findFirst()
                                .get(),
                        value[INDEX_OF_FRUIT],
                        Integer.parseInt(value[INDEX_OF_AMOUNT])))
                .collect(Collectors.toList());
    }
}
