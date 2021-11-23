package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserFromFile;
import core.basesyntax.service.Validator;

public class ParserFromFileImpl implements ParserFromFile<TransactionDto> {
    private Validator validator;

    public ParserFromFileImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        Validator validator = new ValidatorImpl();
        validator.validate(line);
        String[] dataFromLine = line.split(",");
        String type = dataFromLine[0].replaceAll(" ", "");
        return new TransactionDto(type,
                dataFromLine[1], Integer.parseInt(dataFromLine[2]));
    }
}
