package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public List<TransactionDto> parseData(List<String> dataFromFile) {
        List<TransactionDto> transactionList = new ArrayList<>();
        dataFromFile.stream()
                .skip(1)
                .map(line -> line.split(SEPARATOR))
                .forEach(element -> transactionList.add(
                        new TransactionDto(Operation.get(element[OPERATION_TYPE_INDEX]),
                        new Fruit(element[FRUIT_NAME_INDEX]),
                        Integer.parseInt(element[FRUIT_AMOUNT_INDEX]))));
        return transactionList;
    }
}
