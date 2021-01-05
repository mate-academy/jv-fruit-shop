package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParseToList;

import java.util.ArrayList;
import java.util.List;

import static core.basesyntax.model.Operation.fromString;

public class ParseToListImpl implements ParseToList {
    public static final int OPERATION = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;

    @Override
    public List<TransactionDto> parseToTransactions(List<String> dataFromFile) {
        List<TransactionDto> convertedToTransaction = new ArrayList<>();
        for(String value: dataFromFile) {
            String[] splittedData =  value.split(",");
            convertedToTransaction.add(new TransactionDto(fromString(splittedData[OPERATION]),
                    new Fruit(splittedData[FRUIT]) ,Integer.valueOf(splittedData[QUANTITY])));
        }
        return convertedToTransaction;
    }
}
