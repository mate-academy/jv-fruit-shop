package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    public static final String LINE_SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final int VALID_TRANSACTION_LENGTH = 3;
    public static final int CSV_INDEX = 1;

    @Override
    public List<FruitTransaction> parse(List<String> stringList) {
        if (stringList != null && stringList.size() > CSV_INDEX) {
            return stringList.stream()
                   .skip(CSV_INDEX)
                   .map(s -> s.split(LINE_SEPARATOR))
                   .filter(line -> line.length
                           == VALID_TRANSACTION_LENGTH)
                   .map(line -> new FruitTransaction(
                           FruitTransaction.Operation.getOperationByCode(line[OPERATION_INDEX]),
                           line[FRUIT_INDEX],
                           Integer.parseInt(line[QUANTITY_INDEX])
                   )).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
