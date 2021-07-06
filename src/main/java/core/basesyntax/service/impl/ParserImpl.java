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
    public List<Transaction> parseLine(List<String> lines) {
        return lines.stream()
                .skip(1)
                .filter(p -> validator.isLineValid(p))
                .map(p -> p.split(SEPARATOR))
                .map(p -> new Transaction(OperationType
                        .getOperationType(p[0]), p[1], Integer.parseInt(p[2])))
                .collect(Collectors.toList());
    }
}
