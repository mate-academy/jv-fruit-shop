package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.strategy.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDataParser implements DataParser<FruitTransactionDto> {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX_CSV = 0;
    private static final int NAME_INDEX_CSV = 1;
    private static final int QUANTITY_INDEX_CSV = 2;

    @Override
    public List<FruitTransactionDto> parse(List<String> rawData) {
        return rawData.stream()
                .skip(1)
                .map(line -> {
                    String[] columns = line.split(SEPARATOR);
                    if (columns.length != 3) {
                        throw new IllegalArgumentException("Invalid format: " + line);
                    }
                    Operation operation = Operation
                            .validateOperation(columns[OPERATION_TYPE_INDEX_CSV]);
                    String fruitName = columns[NAME_INDEX_CSV];
                    int quantity = Integer.parseInt(columns[QUANTITY_INDEX_CSV]);
                    return new FruitTransactionDto(operation, fruitName, quantity);
                })
                .collect(Collectors.toList());
    }
}
