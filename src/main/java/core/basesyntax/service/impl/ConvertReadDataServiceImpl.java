package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConvertReadDataService;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertReadDataServiceImpl implements ConvertReadDataService {
    private static final byte DATA_TO_REMOVE_INDEX = 0;
    private static final byte OPERATION_INDEX = 0;
    private static final byte FRUIT_NAME_INDEX = 1;
    private static final byte QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<Transaction> convertDataFromFile(List<String> dataFromFile) {
        dataFromFile.remove(DATA_TO_REMOVE_INDEX);
        return dataFromFile.stream()
                .map(s -> s.split(SPLITTER))
                .map(s -> new Transaction(s[OPERATION_INDEX], s[FRUIT_NAME_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
