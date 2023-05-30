package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransaction(List<String> lines) {
        return lines.stream()
                .map(l -> {
                    String[] tokens = l.split(SEPARATOR);
                    return new FruitTransaction(
                            tokens[INDEX_OF_PRODUCT_NAME],
                            FruitTransaction.Operation.getByCode(tokens[INDEX_OF_OPERATION]),
                                                Integer.parseInt(tokens[INDEX_OF_AMOUNT])
                                        );
                })
                .collect(Collectors.toList());
    }
}
