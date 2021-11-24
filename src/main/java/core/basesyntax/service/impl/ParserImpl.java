package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser<TransactionDto> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static Validator validator;

    public ParserImpl(Validator validator) {
        ParserImpl.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        validator.validate(line);
        String[] activities = line.split(",");
        return new TransactionDto(activities[OPERATION_INDEX],
                activities[FRUIT_NAME_INDEX], Integer.parseInt(activities[QUANTITY_INDEX]));
    }
}
