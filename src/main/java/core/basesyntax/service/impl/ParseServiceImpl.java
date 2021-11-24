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
        for (String data : dataFromFile) {
            String[] lineData = data.split(SEPARATOR);
            transactionList.add(
                    new TransactionDto(Operation.get(lineData[OPERATION_TYPE_INDEX]),
                    new Fruit(lineData[FRUIT_NAME_INDEX]),
                    Integer.parseInt(lineData[FRUIT_AMOUNT_INDEX])));
        }
        return transactionList;
    }
}
