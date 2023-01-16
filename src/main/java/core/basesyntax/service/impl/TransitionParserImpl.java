package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransitionParserImpl implements FruitTransactionParser {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_COUNT = 2;
    private static final String SPLITTER = ",";
    private final OperationValidator validator;

    public TransitionParserImpl(OperationValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        return Stream.of(lines)
                .skip(1)
                .map(this::parse)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }

    public List<FruitTransaction> parse(List<String> dataFromFile) {
        String[] data;
        List<FruitTransaction> fruitTransitions = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            data = dataFromFile.get(i).split(SPLITTER);
            fruitTransitions
                    .add(new FruitTransaction(validator.validate(data[INDEX_OF_OPERATION_TYPE]),
                            new Fruit(data[INDEX_OF_FRUIT_TYPE]),
                            Integer.parseInt(data[INDEX_OF_COUNT])));
        }
        return fruitTransitions;
    }
}
