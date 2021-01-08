package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parse;
import java.util.ArrayList;
import java.util.List;

public class ParseCsvImpl implements Parse {
    public static final String COMA = ",";
    public static final int EXPECTED_LENGTH_ARRAY = 3;

    @Override
    public List<TransactionDto> parse(List<String> data) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (String line : data) {
            String[] split = line.split(COMA);
            if (split.length != EXPECTED_LENGTH_ARRAY) {
                throw new IllegalArgumentException("Don't valid data for parse");
            }
            transactionDtoList.add(new TransactionDto(Operation.getOperationByLetter(split[0]),
                    new Fruit(split[1]), Integer.parseInt(split[2])));
        }
        return transactionDtoList;
    }
}
