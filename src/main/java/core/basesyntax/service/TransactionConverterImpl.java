package core.basesyntax.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionConverterImpl implements TransactionConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final String EXP_HEADER = "type,fruit,quantity";

    public List<FruitTransaction> convertLines(List<String> lines) {
        Optional<String> firstLine = lines.stream().findFirst();

        if (firstLine.isPresent() && !firstLine.get().startsWith(EXP_HEADER)) {
            throw new RuntimeException("Input file must start with: " + System.lineSeparator()
                    + "\"" + EXP_HEADER + "\"");
        }

        return lines.stream().skip(1)
                .map(line -> line.split(","))
                .map(values -> new FruitTransaction(
                        values[OPERATION_INDEX],
                        values[FRUIT_TYPE_INDEX],
                        Integer.parseInt(values[FRUIT_AMOUNT_INDEX].trim())
                ))
                .collect(Collectors.toList());
    }

    public record FruitTransaction(String operation, String fruitType, int quantity) {
    }
}
