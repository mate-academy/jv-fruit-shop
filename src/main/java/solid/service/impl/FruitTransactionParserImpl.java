package solid.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import solid.model.FruitTransaction;
import solid.service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_NAME_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String SPLIT_REGEX_CSV = ",";

    @Override
    public List<FruitTransaction> toTransaction(String data) {
        return Arrays.stream(data.split(System.lineSeparator()))
                .skip(1)
                .map(str -> str.split(SPLIT_REGEX_CSV))
                .map(str -> new FruitTransaction(FruitTransaction.Operation
                        .getOperationFromString(str[INDEX_OPERATION].trim()),
                        str[INDEX_NAME_FRUIT],
                        Integer.parseInt(str[INDEX_QUANTITY].trim())))
                .collect(Collectors.toList());
    }
}
