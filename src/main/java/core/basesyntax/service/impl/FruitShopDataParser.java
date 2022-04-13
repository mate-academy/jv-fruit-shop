package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitShopDataParser implements Parser {
    private static final String COMA = ",";
    private static final Integer OPERATION_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer AMOUNT_INDEX = 2;
    private static final Function<String, FruitTransaction.Operation> DEFINE_OPERATION =
            (line) -> FruitTransaction.Operation.of(line.split(COMA)[OPERATION_INDEX]);
    private final Validator validator;

    public FruitShopDataParser(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> getTransactions(List<String> lines) {
        return lines.stream()
                .skip(1)
                .filter(validator::isValid)
                .map(line -> new FruitTransaction(
                        DEFINE_OPERATION.apply(line),
                        new Fruit(line.split(COMA)[FRUIT_INDEX]),
                        Integer.parseInt(line.split(COMA)[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}

