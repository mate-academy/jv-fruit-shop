package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;
import core.basesyntax.strategy.OperationType;

public class ParserImpl implements Parser<TransactionDto> {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseTo(String line) {
        String[] oneLineData = line.split(",");
        if (validator.validate(line)) {
            return new TransactionDto(OperationType.valueOf(oneLineData[OPERATION]),
                    oneLineData[FRUIT_NAME], Integer.parseInt(oneLineData[QUANTITY]));
        } else {
            throw new RuntimeException("Input data is invalid");
        }
    }
}
