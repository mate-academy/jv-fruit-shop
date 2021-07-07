package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<Transaction> parseLines(List<String> lines) {
        return lines.stream()
                .skip(1)
                .filter(line -> validator.isLineValid(line))
                .map(line -> line.split(SEPARATOR))
                .map(strings -> new Transaction(OperationType
                        .getOperationType(strings[0]), strings[1], Integer.parseInt(strings[2])))
                .collect(Collectors.toList());
    }
}
