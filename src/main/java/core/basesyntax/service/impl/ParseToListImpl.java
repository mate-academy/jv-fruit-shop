package core.basesyntax.service.impl;

import static core.basesyntax.model.Operation.fromString;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParseToList;
import java.util.ArrayList;
import java.util.List;

public class ParseToListImpl implements ParseToList {
    public static final int OPERATION = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;
    public static final String COMMA = ",";

    @Override
    public List<TransactionDto> parseToTransactions(List<String> dataFromFile) {
        if (dataFromFile == null) {
            throw new RuntimeException(String.format("No data in the file %s", dataFromFile));
        }
        List<TransactionDto> convertedToTransaction = new ArrayList<>();
        for (String value : dataFromFile) {
            String[] splittedData = value.split(COMMA);
            convertedToTransaction.add(new TransactionDto(fromString(splittedData[OPERATION]),
                    new Fruit(splittedData[FRUIT]), Integer.valueOf(splittedData[QUANTITY])));
        }
        return convertedToTransaction;
    }
}
