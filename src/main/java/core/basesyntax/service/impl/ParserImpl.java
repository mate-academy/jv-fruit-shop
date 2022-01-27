package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser<TransactionDto> {
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<TransactionDto> parse(List<String> lines) {
        lines.remove(0);
        validator.isValid(lines);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        String[] splittedLine;
        TransactionDto transactionDto;
        for (String line : lines) {
            splittedLine = line.split(",");
            transactionDto = new TransactionDto(splittedLine[ValidatorImpl.OPERATION_INDEX].trim(),
                    new Fruit(splittedLine[ValidatorImpl.FRUIT_INDEX]),
                    Integer.parseInt(splittedLine[ValidatorImpl.QUANTITY_INDEX]));
            transactionDtos.add(transactionDto);
        }
        return transactionDtos;
    }
}
