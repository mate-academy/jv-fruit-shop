package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidDataTypeException;
import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.DataParseService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParseServiceImpl implements DataParseService {
    private static final String ARRAY_SPLITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int LENGTH = 3;

    @Override
    public List<FruitsTransaction> getTransactionList(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitsTransaction parseTransaction(String data) {
        String[] dataArray = data.split(ARRAY_SPLITER);
        if (dataArray.length != LENGTH) {
            throw new InvalidDataTypeException("Invalid data format");
        }

        String operation = dataArray[OPERATION_INDEX];
        String name = dataArray[NAME_INDEX];
        int quantity = Integer.parseInt(dataArray[QUANTITY_INDEX]);
        return new FruitsTransaction(operation, name, quantity);
    }
}
