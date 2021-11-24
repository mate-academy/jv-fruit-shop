package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidatorService;

public class ParserServiceImpl implements ParserService<TransactionDto> {
    private ValidatorService validatorService;

    public ParserServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public TransactionDto parseLine(String line) {
        if (!validatorService.validate(line)) {
            throw new RuntimeException("Invalid input format");
        }
        String[] components = line.split(",");
        return new TransactionDto(components[0], components[1],
                Integer.parseInt(components[2]));
    }
}
