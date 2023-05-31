package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransaction(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    String[] tokens = line.split(SEPARATOR);
                    return new FruitTransaction(
                            tokens[PRODUCT_NAME_INDEX],
                            FruitTransaction.Operation.getByCode(tokens[OPERATION_INDEX]),
                                                Integer.parseInt(tokens[AMOUNT_INDEX])
                                        );
                })
                .collect(Collectors.toList());
    }
}
