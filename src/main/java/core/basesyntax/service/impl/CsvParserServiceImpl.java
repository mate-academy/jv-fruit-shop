package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidatorService;
import java.util.ArrayList;
import java.util.List;

public class CsvParserServiceImpl implements ParserService<TransactionDto> {
    private static final String FIRST_LINE = "type,fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA_SEPARATOR = ",";

    private ValidatorService validator;

    public CsvParserServiceImpl(ValidatorService validator) {
        this.validator = validator;
    }

    @Override
    public List<TransactionDto> parseLines(List<String> list) {
        if (list.get(0).equals(FIRST_LINE)) {
            list.remove(0);
        }
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (String line : list) {
            validator.validate(line);
            String[] information = line.split(COMMA_SEPARATOR);
            transactionDtos.add(new TransactionDto(information[OPERATION_INDEX],
                    information[FRUIT_INDEX],
                    Integer.parseInt(information[QUANTITY_INDEX])));
        }
        return transactionDtos;
    }
}
