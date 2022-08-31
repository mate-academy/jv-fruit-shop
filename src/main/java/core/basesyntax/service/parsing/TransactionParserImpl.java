package core.basesyntax.service.parsing;

import core.basesyntax.model.FruitTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> records) {
        return records.stream()
                .map(r -> r.split(DATA_SEPARATOR))
                .map(record -> new FruitTransaction(getOperation(record[OPERATION_TYPE]),
                        record[FRUIT_TYPE], Integer.parseInt(record[QUANTITY])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String operation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(v -> v.getOperationIndex().equals(operation))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Incorrect operation type: " + operation));
    }
}
