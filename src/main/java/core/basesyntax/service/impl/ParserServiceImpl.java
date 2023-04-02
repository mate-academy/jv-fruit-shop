package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService<Transaction> {
    private static final String DEFAULT_DELIMITER = " ";
    private String delimiter;

    public ParserServiceImpl() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public ParserServiceImpl setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    private Operation getOperation(String operationMark) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperationMark().equals(operationMark))
                .findAny()
                .orElseThrow(() -> new RuntimeException(
                        "No such operation marked as " + operationMark));
    }

    @Override
    public List<Transaction> parse(List<String> stringList) {
        return stringList.stream()
                .map(s -> s.split(delimiter))
                .skip(1)
                .map(s -> new Transaction(getOperation(s[0]),
                        Fruit.of(s[1]), Integer.parseInt(s[2])))
                .collect(Collectors.toList());
    }
}
