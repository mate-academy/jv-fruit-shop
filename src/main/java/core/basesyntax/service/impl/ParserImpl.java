package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> {
                    String[] splitter = line.split(",");
                    FruitTransaction fruit = new FruitTransaction();
                    fruit.setOperation(FruitTransaction.Operation
                            .getCode(splitter[OPERATION_INDEX]));
                    String fruitOperation = splitter[FRUIT_INDEX];
                    fruit.setFruit(fruitOperation);
                    fruit.setAmount(Integer.parseInt(splitter[AMOUNT_INDEX]));
                    return fruit;
                }).collect(Collectors.toList());
    }
}
