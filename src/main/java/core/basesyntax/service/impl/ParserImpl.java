package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser<TransactionDto> {
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        if (!validator.validate(line)) {
            throw new RuntimeException("Invalid input format");
        }
        String[] components = line.split(",");
        return new TransactionDto(components[0], components[1],
                Integer.parseInt(components[2]));
    }
}
