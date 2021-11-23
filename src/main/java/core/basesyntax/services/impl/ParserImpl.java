package core.basesyntax.services.impl;

import core.basesyntax.models.TransactionDto;
import core.basesyntax.services.Parser;
import core.basesyntax.services.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser<TransactionDto> {
    private static final int OPERATION_NUMBER = 0;
    private static final int FRUIT_NAME_NUMBER = 1;
    private static final int FRUIT_QUANTITY_NUMBER = 2;
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<TransactionDto> parse(List<String> lines) {
        List<TransactionDto> result = new ArrayList<>();
        int lineNumber = 0;
        for (String line : lines) {
            if (lineNumber > 0) {
                validator.validate(line);
                String[] data = line.split(",");
                int fruitQuantity = Integer.parseInt(data[FRUIT_QUANTITY_NUMBER]);
                result.add(new TransactionDto(data[OPERATION_NUMBER],
                        data[FRUIT_NAME_NUMBER], fruitQuantity));
            }
            lineNumber++;
        }
        return result;
    }
}
