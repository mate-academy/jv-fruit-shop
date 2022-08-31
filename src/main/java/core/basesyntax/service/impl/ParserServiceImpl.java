package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int HEADER_INDEX = 0;
    private static final String COMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        data.remove(HEADER_INDEX);
        return data.stream()
                .map(s -> s.split(COMA))
                .map(v -> new FruitTransaction(
                        getTransaction(v),
                        v[INDEX_OF_FRUIT],
                        Integer.parseInt(v[INDEX_OF_AMOUNT])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getTransaction(String[] strings) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(strings[INDEX_OF_OPERATION]))
                .findFirst().get();
    }
}
