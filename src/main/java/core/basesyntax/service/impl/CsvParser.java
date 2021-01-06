package core.basesyntax.service.impl;

import core.basesyntax.exceptions.NegativeQuantityException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<TransactionDto> parse(List<String> data) {
        List<TransactionDto> transactionsList = new ArrayList<>();
        for (String item : data) {
            String[] parsedData = item.split(",");
            Integer currentAmount = Integer.parseInt(parsedData[QUANTITY_INDEX]);
            if (currentAmount < 0) {
                throw new NegativeQuantityException(String
                        .format("Buyers will not be able to %s %s %s. %s incorrect input.",
                        Operation.fromString(parsedData[OPERATION_INDEX]),
                        currentAmount,
                        parsedData[FRUIT_NAME_INDEX],
                        parsedData[FRUIT_NAME_INDEX],
                        currentAmount));
            }
            TransactionDto transactionDto =
                    new TransactionDto(Operation.fromString(parsedData[OPERATION_INDEX]),
                    new Fruit(parsedData[FRUIT_NAME_INDEX]), currentAmount);
            transactionsList.add(transactionDto);
        }
        return transactionsList;
    }
}
