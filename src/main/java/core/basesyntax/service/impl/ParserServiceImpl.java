package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    public static final String COMA_SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    private static final int VALID_TRANSACTION_LENGTH = 3;
    private static final int CSV_TITLE_INDEX = 1;

    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        if (strings != null && strings.size() > 1) {
            List<String> dataRows = strings.subList(CSV_TITLE_INDEX, strings.size());
            fruitTransactions = dataRows.stream()
                    .map(string -> string.split(COMA_SEPARATOR))
                    .filter(parts -> parts.length == VALID_TRANSACTION_LENGTH)
                    .map(parts -> new FruitTransaction(
                            FruitTransaction.Operation.getOperationByCode(parts[OPERATION_INDEX]),
                            parts[FRUIT_INDEX],
                            Integer.parseInt(parts[QUANTITY_INDEX])
                    ))
                    .collect(Collectors.toList());
        }
        return fruitTransactions;
    }
}
