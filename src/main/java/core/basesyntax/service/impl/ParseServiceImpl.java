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
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        if (stringList != null && stringList.size() > 1) {
            List<String> dataRow = stringList.subList(CSV_INDEX, stringList.size());
            fruitTransactionList = dataRow.stream()
                    .map(s -> s.split(LINE_SEPARATOR))
                    .filter(p -> p.length == VALID_TRANSACTION_LENGTH)
                    .map(p -> new FruitTransaction(
                            FruitTransaction.Operation.getOperationByCode(p[OPERATION_INDEX]),
                    p[FRUIT_INDEX],
                            Integer.parseInt(p[QUANTITY_INDEX])
                    ))
                    .collect(Collectors.toList());
        }
        return fruitTransactionList;
    }
}
