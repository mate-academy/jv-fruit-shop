package core.basesyntax.mapper;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public class FruitTransactionMapper {
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    public List<FruitTransaction> mapToFruitTransactions(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line.split(COMA_SEPARATOR))
                .map(this::mapToFruitTransaction)
                .toList();
    }

    private FruitTransaction mapToFruitTransaction(String[] splittedLine) {
        FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(splittedLine[INDEX_OF_OPERATION]);
        String fruit = splittedLine[INDEX_OF_FRUIT];
        Integer quantity = Integer.valueOf(splittedLine[INDEX_OF_QUANTITY]);
        return new FruitTransaction(
            operation,
            fruit,
            quantity
        );
    }
}
