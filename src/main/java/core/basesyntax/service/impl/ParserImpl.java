package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser<TransactionDto> {
    private static byte OPERATION_INDEX = 0;
    private static byte FRUIT_NAME_INDEX = 1;
    private static byte QUANTITY_INDEX = 2;
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        validator.validate(line);
        String[] dataFromLine = line.split(",");
        return new TransactionDto(dataFromLine[OPERATION_INDEX],
                dataFromLine[FRUIT_NAME_INDEX], Integer.parseInt(dataFromLine[QUANTITY_INDEX]));
    }
}
