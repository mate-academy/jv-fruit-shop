package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidatorService;

public class ParserServiceImpl implements ParserService<TransactionDto> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ValidatorService validatorService;

    public ParserServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public TransactionDto parseLine(String line) {
        if (!validatorService.validate(line)) {
            throw new RuntimeException("Invalid input format");
        }
        String[] components = line.split(",");
        return new TransactionDto(components[OPERATION_INDEX], components[FRUIT_NAME_INDEX],
                Integer.parseInt(components[QUANTITY_INDEX]));
    }
}
