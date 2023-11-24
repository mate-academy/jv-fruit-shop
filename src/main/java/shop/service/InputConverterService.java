package shop.service;

import java.util.List;
import java.util.stream.Collectors;
import shop.model.FruitTransaction;

public class InputConverterService {
    private static final int HEADERS_LINES_NUM = 1;
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;

    public List<FruitTransaction> convertToTransactions(List<String[]> data) {
        return data.stream()
                .skip(HEADERS_LINES_NUM)
                .map(this::convertToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToTransaction(String[] record) {
        return new FruitTransaction(
                FruitTransaction.Operation.valueOfCode(record[OPERATION_POSITION]),
                record[FRUIT_POSITION],
                Integer.parseInt(record[QUANTITY_POSITION]));
    }
}
