package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        final int[] lineCount = {0};
        rawData.stream()
                .filter(line -> {
                    lineCount[0]++;
                    return line != null && !line.trim().isEmpty() && lineCount[0] > 1;
                })
                .map(line -> line.split(","))
                .forEach(parts -> {
                    fruitTransactions
                            .add(new FruitTransaction(parseOperation(parts[0]
                                    .trim()
                                    .toLowerCase()), parts[1]
                                    .trim(), Integer.parseInt(parts[2].trim())));
                });
        return fruitTransactions;
    }

    private FruitTransaction.Operation parseOperation(String code) {
        return switch (code) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException(
                    "Invalid operation code: " + code + ". Expected: b, s, p, or r");
        };
    }
}
