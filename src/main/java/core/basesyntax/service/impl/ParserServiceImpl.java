package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final String FIELD_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> getRecords(List<String> lines) {
        Function<String[], FruitTransaction> lineToOperation = strings -> {
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getByCode(strings[INDEX_OF_OPERATION]);
            int quantity = Integer.parseInt(strings[INDEX_OF_AMOUNT]);
            String fruit = strings[INDEX_OF_PRODUCT_NAME];
            return new FruitTransaction(operation, fruit, quantity);
        };
        return IntStream.range(1, lines.size())
                .mapToObj(i -> lines.get(i).split(FIELD_SEPARATOR))
                .map(lineToOperation).toList();
    }
}
