package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParserService;
import core.basesyntax.service.ValidatorService;
import java.util.ArrayList;
import java.util.List;

public class CsvParserServiceImpl implements CsvParserService<TransactionDto> {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_OF_FRUIT_INDEX = 1;
    private static final int QUANTITY_OF_FRUITS_INDEX = 2;

    private ValidatorService<String> validatorService;

    public CsvParserServiceImpl(ValidatorService<String> validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public List<TransactionDto> parse(List<String> list) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        list.remove(0);
        for (String line : list) {
            validatorService.validate(line);
            String[] information = line.split(",");
            transactionDtoList.add(new TransactionDto(information[OPERATION_INDEX],
                    information[NAME_OF_FRUIT_INDEX],
                    Integer.parseInt(information[QUANTITY_OF_FRUITS_INDEX])));
        }
        return transactionDtoList;
    }
}
