package solid.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int indexOperation = 0;
    private static final int indexNameFruit = 1;
    private static final int indexQuantity = 2;
    private static final String splitRegexCsv = ",";

    @Override
    public List<FruitTransaction> toTransaction(String data) {
        return Arrays.stream(data.split(System.lineSeparator()))
                .skip(1)
                .map(str -> str.split(splitRegexCsv))
                .map(str -> new FruitTransaction(FruitTransaction.Operation
                        .getOperationFromString(str[indexOperation].trim()),
                        str[indexNameFruit],
                        Integer.parseInt(str[indexQuantity].trim())))
                .collect(Collectors.toList());
    }
}
