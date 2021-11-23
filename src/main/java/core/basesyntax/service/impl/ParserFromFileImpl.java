package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserFromFile;
import core.basesyntax.service.Validator;

public class ParserFromFileImpl implements ParserFromFile<TransactionDto> {
    private static byte OPERATION_INDEX = 0;
    private static byte FRUIT_NAME_INDEX = 1;
    private static byte QUANTITY_INDEX = 2;
    private Validator validator;

    public ParserFromFileImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        Validator validator = new ValidatorImpl();
        validator.validate(line);
        String[] dataFromLine = line.split(",");
        String type = dataFromLine[OPERATION_INDEX].replaceAll(" ", "");
        return new TransactionDto(type,
                dataFromLine[FRUIT_NAME_INDEX], Integer.parseInt(dataFromLine[QUANTITY_INDEX]));
    }
}
