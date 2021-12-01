package core.basesyntax.service.parser;

import core.basesyntax.dto.TransactionDto;
import core.basesyntax.service.validator.Validator;

public class ParserImpl implements Parser {
    private static final int TYPE_OF_HANDLER = 0;
    private static final int KIND_OF_FRUIT = 1;
    private static final int QUANTITY_OF_FRUIT = 2;
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        if (validator.isValid(line)) {
            String[] data = line.split(",");
            return new TransactionDto(data[TYPE_OF_HANDLER],
                    data[KIND_OF_FRUIT], Integer.parseInt(data[QUANTITY_OF_FRUIT]));
        }
        throw new RuntimeException("Not correct line : " + line);
    }
}
