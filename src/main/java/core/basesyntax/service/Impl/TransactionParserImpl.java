package core.basesyntax.service.Impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int INDEX_CODE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        if (data != null && data.isEmpty()) {
            throw new RuntimeException("Not data found");
        }
        try {
            return data.stream()
                    .map(element -> element.split(SEPARATOR))
                    .map(element -> new FruitTransaction(FruitTransaction.Operation
                            .getOperationByCode(element[INDEX_CODE_OPERATION]),
                            element[INDEX_FRUIT_NAME],
                            Integer.parseInt(element[INDEX_FRUIT_QUANTITY])))
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new RuntimeException("Invalid data");
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid value for fruit quantity");
        }
    }
}
