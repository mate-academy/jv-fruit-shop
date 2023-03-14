package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParserService {
    public static final String SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        return strings.stream()
                .map(string -> string.split(SEPARATOR))
                .map(parts -> new FruitTransaction(
                        FruitTransaction.Operation
                                .getOperationByCode(parts[OPERATION_INDEX]),
                        parts[FRUIT_INDEX],
                        Integer.parseInt(parts[QUANTITY_INDEX])
                ))
                .collect(Collectors.toList());
    }
}
