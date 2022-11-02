package Implementation;

import Service.FruitParser;
import core.basesyntax.FruitTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public FruitTransaction parseTransaction(String line) {
        String[] fields = line.split(SEPARATOR);
        FruitTransaction.Operation operation =
                FruitTransaction.getOperationByLetter(fields[OPERATION_INDEX]);
        return FruitTransaction.of(operation, fields[FRUIT_NAME_INDEX],
                Integer.parseInt(fields[FRUIT_AMOUNT_INDEX]));
    }
}
