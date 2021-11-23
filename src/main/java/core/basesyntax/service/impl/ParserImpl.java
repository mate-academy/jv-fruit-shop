package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser {
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseTo(String line) {
        String[] oneLineData = line.split(",");
        if (validator.validate(line)) {
            return new TransactionDto(oneLineData[0], oneLineData[1],
                    Integer.parseInt(oneLineData[2]));
        } else {
            throw new RuntimeException("input data is invalid");
        }
    }
}
